package com.techidea.theroywhy;

import com.google.gson.Gson;
import com.techidea.theroywhy.net.Response;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testResponse() throws Exception {
        Gson gson = new Gson();
        String response = "{\"ReqTransDate\":\"140421\",\"TransIndexCode\":\"14526855\"," +
                "\"ReqTransTime\":\"100445\",\"AppVersion\":\"FG[201611081650]\"," +
                "\"AppID\":\"12498423\",\"MID\":\"102440183986056\",\"TrxID\":\"78978926123456\"," +
                "\"BatchNum\":471,\"RespCode\":\"15\",\"TransAmount\":\"00000000001\"," +
                "\"TID\":\"05031532\",\"RespDesc\":\"此卡无对应发卡方\"," +
                "\"TransType\":1,\"AppName\":\"test账户\",\"CertNum\":\"000039\"}";

        String responseR = "{\"ReqTransDate\":\"140421\",\"HasReversal\":\"1\",TransIndexCode\":\"14526855\"," +
                "\"ReqTransTime\":\"100445\",\"AppVersion\":\"FG[201611081650]\",\"AppID\":\"12498423\"," +
                "\"MID\":\"102440183986056\",\"TrxID\":\"78978926123456\",\"BatchNum\":471,\"RespCode\":\"15\"," +
                "\"TransAmount\":\"00000000001\",\"TID\":\"05031532\"," +
                "\"RespDesc\":\"此卡无对应发卡方\",\"TransType\":1,\"AppName\":\"test账户\",\"CertNum\":\"000039\"}";
        Response response1 = new Response();
        response1 = gson.fromJson(responseR, Response.class);

        System.out.println(response1.getHasReversal());

    }

    @Test
    public void testJavaOperator() {

/*        mPrivateFlags |= PFLAG_PRESSED;
    } else {
        mPrivateFlags &= ~PFLAG_PRESSED;*/
        int operator1 = 1;
        int operator2 = 0;
        operator2 |= operator1;
        Assert.assertEquals(1, operator2);
        int operator3 = 1;  //001  110  第一位是符号位  -2
        int operator4 = 0;  //000   111
//        Assert.assertEquals(1, ~operator4);
//        Assert.assertEquals(0, ~operator3);//-2  位取反
        System.out.println(String.valueOf(~operator3)); //1 -2
        System.out.println(String.valueOf(~operator4));// 0 -1
        System.out.println(String.valueOf(~2));// 2 -3
        int operator5 = 0;
        int operator6 = 1;
        operator6 &= ~operator5;
        Assert.assertEquals(1, operator6);

    }

    @Test
    public void testRandom() {
        int[] results = randomNumber(12);
        for (int i = 0; i < results.length; i++)
            System.out.println(results[i]);
    }

    public int[] randomNumber(int n) {
        //[2-23] length  = n
        int[] result = new int[n];

        int i = 0;
        Random random = new Random(System.currentTimeMillis());
        while (i < n) {
            int randomTmp = Math.abs(random.nextInt()) % 21 + 2;
            if (!contains(result, randomTmp)) {
                result[i] = randomTmp;
                i++;
            }
        }
        return result;
    }

    private boolean contains(int[] params, int param) {
        boolean result = false;
        for (int i = 0; i < params.length; i++) {
            if (param == params[i])
                result = true;
        }
        return result;
    }
}