package com.zxw;

import com.zxw.auth.entity.UserInfo;
import com.zxw.auth.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

public class springboottest {
    private static final String pubKeyPath = "C:\\Users\\zxw\\Desktop\\key/rsa.pub";
    private static final String priKeyPath = "C:\\Users\\zxw\\Desktop\\key\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
//        String token = com.zxw.auth.utils.JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
//        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU2MTA4MTM4OX0.FE6UvlKOEH3qq3K5YNce0ZAyw1AQWCHHBXP1QZLnkVIVVEKaLAOG8IN5evIZX1HV_-GM0tOVVpRori3wgg6aE9ErdcUIyfmR791nL-0oCDX4sD4cEjAjqsONzxUkpSN-_YdAQw0gqQH4BOYDl3sKvPd-lpgH00L00X-0v7UVb3A";

        // 解析token
        UserInfo user = com.zxw.auth.utils.JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}
