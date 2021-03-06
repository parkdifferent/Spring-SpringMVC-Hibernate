package com.mangosis.ssh.controller;

import com.google.zxing.WriterException;
import com.mangosis.ssh.qrcode.CrunchifyQRCode;
import com.mangosis.ssh.util.VerifyCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 2017/5/11.
 */

@Controller
public class AuthImagesController {

    private static final Logger logger = LoggerFactory.getLogger(AuthImagesController.class);

/*    @Reference(version = Const.XBIN_STORE_REDIS_VERSION)
    private JedisClient jedisClient;

    @Value("${redisKey.prefix.verifycode}")
    private String VERIFYCODE;

    @Value("${redisKey.expire_time}")
    private Integer EXPIRE_TIME;*/

    @RequestMapping(value = "/verify/image", method = RequestMethod.GET)
    public void verifyimage(/*String uid, */HttpServletResponse response) {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);

        int w = 100, h = 30;
        try {
            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
        } catch (IOException e) {
            logger.error("验证码生成失败", e);
        }

    }

    @RequestMapping(value = "/qrcode/image", method = RequestMethod.GET)
    public void genQRCode(/*String uid, */HttpServletResponse response) {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/png");


        String myCodeText = "https://crunchify.com/";
        String filePath = "D:\\CrunchifyQR.png";
        int size = 250;
        String fileType = "png";
        File myFile = new File(filePath);
        CrunchifyQRCode crunchifyQRCode = new CrunchifyQRCode();

        try {
            crunchifyQRCode.createQRImage1(response.getOutputStream(),myCodeText,size,fileType);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n\nYou have successfully created QR Code.");

    }
}
