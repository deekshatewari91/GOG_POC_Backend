package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter{
	
	private String clientid = "my-client-id";
	private String clientSecret = "my-secret-key";
	private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpQIBAAKCAQEAvfJaq5yMphI93grZSzeBZ+NK6POCMkn5DVNLxDhcVCPDhX6U\r\n" + 
			"pZqIiKX2rSue9l+sRlVNgOwNC9sWjD8+70F/5xx1txN0C/nPoF2Q1aOVJDYq7OMN\r\n" + 
			"0HNvmM6k38/K/76UMIvyK+2djnQRWiN2zDNFQIgAVf8FvnP+HrV7pOF1C1zg3H6j\r\n" + 
			"rzXrc4vCzjgf5q0+amNlf6ysI1+Vk32RbFTg6kOBVfnCzm2I3TFp8zpNF0yfDiaG\r\n" + 
			"CPKU0i9rZZQfI4MF6KArGtkY7q5NJttCrn6TiSqqK/7++EJqiQDr4om9zn+/Fhoa\r\n" + 
			"TtOXN3YR56dWTw9nFcAquFqK/klVLAH9rWy7AQIDAQABAoIBACidMm/xSE2WJu5c\r\n" + 
			"SXwAwUWyXukScCtKj9sejVvGZU+EWiEoIKaMNVdqjSUX56RsboyXXrwLPPrk/Jw+\r\n" + 
			"Rbmouq1y82SS30RUROXYO8jCcnhMsL74CZMhq6HzxWMprhEi8dKzibOE2iSEgtVQ\r\n" + 
			"Me2VpOAYdGHu5o6DhLmSOn7Vyk4ETjTlGb8JwEwf6jDaJr2j5q57iLOmCtrvZjRC\r\n" + 
			"DGXZPRRcaX0KaKqUDlwRrcPu9b2ku0WATBf7aWFr7l69IpI4z1ejbcguYWZhS7z+\r\n" + 
			"KOvePI9zzUpZutBorEG7PTssR2MhN0jCVjxNCpCbj9yVROGSSq1t7QCybn2E1vGa\r\n" + 
			"WVtxLfECgYEA89kVRssgw56dQrh6Oco8AwlP5rgALa3NgMSOrLGI8hTFR5kXAQh2\r\n" + 
			"JwKAiIGSBoGP3CfR1Ee/Pu1n6INch3urWsXIKwNN8PCrmFExt2c9wunmUUUKRnEX\r\n" + 
			"mwh+LtKKnJ0xCIGZI4TzGUW0YIq7qQbLyDVgpBTtn85ZTKXMiQZ4hBUCgYEAx2me\r\n" + 
			"n3EEV5tYO+2wwLgB3BnE761xzjiVu4RWVmGm2UQQmPbtbmUcSUfPOmIiR8eVijUh\r\n" + 
			"wA3UJhGyThfO9ivv0+ddaMwb44/WWQK3Ans+P93B/HWib3NRhzSFm37JiYSaGcxS\r\n" + 
			"XEvfTpR0rnShjVVJXueGAqKhyPiFwWoIdeFGuj0CgYEA4dfa5thXHhaXnCXzvfZa\r\n" + 
			"Io3LXOpp7+SbAnoJklRTe7JVDPzy21gU5ghhNwyaTEBPFx4iLrPMouGKbUTMvAaE\r\n" + 
			"K+wmef/zfgXJR6dbnnuWLiIn2HlTDO7NaB8zjvYcvvSvZytww/7skCmI6ClVqTTM\r\n" + 
			"JD+bpBxmAK5C8sRUbUx67gkCgYEAlzTRYJjz7/INH7QGGLvuPRUVLaBY8UQa1Ytt\r\n" + 
			"ZCa7u3dPFo32T4U/w5k920laMQ93psrPAq/5s7wrdee7uRJr0kRXogVTCGSi5e+X\r\n" + 
			"Ebyd4ROn6mTQfK32ng0HWnbzHuF7cCBsOywU8aLELxyk+2Q2NE5eYVUsVBWOZrCe\r\n" + 
			"JbRiSwkCgYEAsEIx0x8bnyyw9ROJaRMAzj8Y0UGzvHK6s7gQW8JTfbLPT7C44/jA\r\n" + 
			"wrJSYZ6e1+l98Lvtp3R+G+0l8gaLVGdgADxzdu+wsOXhzoYpdfXa9DcBEUGafYBy\r\n" + 
			"lIkuNmG+9iiQFnM0GcY/CbhsUVVskM5l+Pl2hh0NVKL4tq4Jn/Bnjn8=\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	private String publicKey = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvfJaq5yMphI93grZSzeB\r\n" + 
			"Z+NK6POCMkn5DVNLxDhcVCPDhX6UpZqIiKX2rSue9l+sRlVNgOwNC9sWjD8+70F/\r\n" + 
			"5xx1txN0C/nPoF2Q1aOVJDYq7OMN0HNvmM6k38/K/76UMIvyK+2djnQRWiN2zDNF\r\n" + 
			"QIgAVf8FvnP+HrV7pOF1C1zg3H6jrzXrc4vCzjgf5q0+amNlf6ysI1+Vk32RbFTg\r\n" + 
			"6kOBVfnCzm2I3TFp8zpNF0yfDiaGCPKU0i9rZZQfI4MF6KArGtkY7q5NJttCrn6T\r\n" + 
			"iSqqK/7++EJqiQDr4om9zn+/FhoaTtOXN3YR56dWTw9nFcAquFqK/klVLAH9rWy7\r\n" + 
			"AQIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public JwtAccessTokenConverter tokenEnhancer() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(privateKey);
		converter.setVerifierKey(publicKey);
		return converter;
	}
	
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(tokenEnhancer());
	}
	
	@Override
	   public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	      endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
	      .accessTokenConverter(tokenEnhancer());
	   }
	
	@Override
	   public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
	      security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	   }

	@Override
	   public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	      clients.inMemory().withClient(clientid).secret(passwordEncoder.encode(clientSecret)).scopes("read", "write")
	         .authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
	         .refreshTokenValiditySeconds(20000);
	   }
}
