package com.yruns.thirdparty.controller;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.Headers;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.BasicSessionCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.auth.COSSigner;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.region.Region;
import com.yruns.common.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * OosController for
 *
 * @Author yruns
 * @Version 2023/6/30
 */

@RestController
public class OosController {

    @GetMapping("/oos/policy")
    // 创建 COSClient 实例，这个实例用来后续调用请求
    public R oosSign() {
        // 设置用户身份信息。
        // SECRETID 和 SECRETKEY 请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        String secretId = System.getenv("secretId");//用户的 SecretId，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        String secretKey = System.getenv("secretKey");//用户的 SecretKey，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

        // 存储桶的命名格式为 BucketName-APPID，此处填写的存储桶名称必须为此格式
        String bucketName = "examplebucket-1250000000";
        // 对象键(Key)是对象在存储桶中的唯一标识。详情请参见 [对象键](https://cloud.tencent.com/document/product/436/13324)
        String key = "exampleobject";
        //若 key不是以“/”开头，则需要在 key 的开头加上“/”，否则直接 resource_path=key
        String resource_path="/" + key;

        ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing-1"));

        // 用来生成签名
        COSSigner signer = new COSSigner();
        // 设置签名过期时间(可选)，若未进行设置，则默认使用 ClientConfig 中的签名过期时间(1小时)
        // 这里设置签名在半个小时后过期
        Date expirationDate = new Date(System.currentTimeMillis() + 30L * 60L * 1000L);

        // 填写本次请求的参数
        Map<String, String> params = new HashMap<String, String>();
        params.put("param1", "value1");

        // 填写本次请求的头部
        Map<String, String> headers = new HashMap<String, String>();
        // host 必填
        headers.put(Headers.HOST, clientConfig.getEndpointBuilder().buildGeneralApiEndpoint(bucketName));
        headers.put("header1", "value1");

        // 请求的 HTTP 方法，上传请求用 PUT，下载请求用 GET，删除请求用 DELETE
        HttpMethodName method = HttpMethodName.GET;

        String sign = signer.buildAuthorizationStr(method, resource_path, headers, params, cred, expirationDate, true);

        return R.ok().put("sign", sign);
    }
}
