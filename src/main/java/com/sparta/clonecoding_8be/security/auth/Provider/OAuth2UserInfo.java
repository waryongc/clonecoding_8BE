package com.sparta.clonecoding_8be.security.auth.Provider;

public interface OAuth2UserInfo {
    String getProviderId();
    String getProvider();
    String getEmail();
    String getName();

}
