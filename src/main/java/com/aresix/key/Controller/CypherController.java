package com.aresix.key.Controller;

import com.aresix.key.pojo.CryptoText;
import com.aresix.key.pojo.Plaintext;
import com.aresix.key.result.Result;
import com.aresix.key.utils.AES256;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin
public class CypherController {
    private String pt = null;

    @CrossOrigin
    @PostMapping(value = "api/cipher")
    @ResponseBody
    public Result cypher(@RequestBody Plaintext requestPlaintext) throws Exception {
        String context = HtmlUtils
                .htmlEscape(requestPlaintext.getContext());


        System.out.println("收到的内容为： " + context);
        pt = context;
        System.out.println("此时临时变量（？）pt的值为：" + pt);
//        String plainT = AES256.decryptAES(context);
//        System.out.println("解密后为： " + plainT);
//        System.out.println(plainT.getBytes(StandardCharsets.UTF_8));
        return new Result(200);
    }

    @CrossOrigin
    @GetMapping(value = "/api/decipher")
    public String decipher() throws Exception {
        //        pt = AES256.decryptAES(pt).trim();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String newPt = CryptoText.answer(pt);
        return AES256.encryptAES(newPt);
    }
}
