package com.yruns.product;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.yruns.product.service.BrandService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

/**
 * CosTest for
 *
 * @Author yruns
 * @Version 2023/6/30
 */
@SpringBootTest
public class CosTest {

    @Autowired
    BrandService brandService;

    private String bucketName;
    private COSClient cosClient;

    // 初始化配置
    @Before
    public void setUp() {
        String secretId = "AKIDe7KHwLTKuCDxReaGgphIcfRwB9pENFqA";
        String secretKey = "oMddMp1way5vUnpa4IGxMUMwFH3XliOo";
//        String cosRegion = "project-file-storage-1308109046-100022082036.cos.ap-nanjing.myqcloud.com";
        bucketName = "project-file-storage-1308109046";
        String cosRegion = "ap-nanjing";


        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的地域, COS 地域的简称请参见 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。\

        Region region = new Region(cosRegion);
        ClientConfig clientConfig = new ClientConfig(region);
        // 这里建议设置使用 https 协议
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        cosClient = new COSClient(cred, clientConfig);

        System.out.println("初始化配置成功");
    }

    @Test
    public void testUpload() {


//        List<Bucket> buckets = cosClient.listBuckets();
//        for (Bucket bucketElement : buckets) {
//            String bucketName = bucketElement.getName();
//            String bucketLocation = bucketElement.getLocation();
//            System.out.println(bucketLocation + bucketName);
//        }

        // 指定要上传的文件
        File localFile = new File("C:\\Users\\86185\\Pictures\\stepbro_282py9 (2).png");
        // 指定文件将要存放的存储桶
           // <bucketName>
        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String objectName = "cloud-store/" + "test2.png";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        System.out.println(putObjectResult);

    }

    @Test
    public void testDownload() throws IOException {
        // 删除指定对象
        // 指定被删除的文件在 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示删除位于 folder 路径下的文件 picture.jpg
        String key = "cloud-store/" + "test2.png";
        // 方法1 获取下载输入流
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
        COSObject cosObject = cosClient.getObject(getObjectRequest);
        COSObjectInputStream cosObjectInput = cosObject.getObjectContent();
        // 下载对象的 CRC64
        String crc64Ecma = cosObject.getObjectMetadata().getCrc64Ecma();
        // 关闭输入流
        cosObjectInput.close();

        // 方法2 下载文件到本地的路径，例如 D 盘的某个目录
        String outputFilePath = "C:\\Users\\86185\\Pictures\\test.png";
        File downFile = new File(outputFilePath);
        getObjectRequest = new GetObjectRequest(bucketName, key);
        ObjectMetadata downObjectMeta = cosClient.getObject(getObjectRequest, downFile);
    }

    @Test
    public void testDelete() {
        // 删除指定对象
        // 指定被删除的文件在 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示删除位于 folder 路径下的文件 picture.jpg
        String key = "cloud-store/" + "test.png";
        cosClient.deleteObject(bucketName, key);
    }
}
