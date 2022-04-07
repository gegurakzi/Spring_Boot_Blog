package com.cos.blog.model;

import lombok.Data;

@Data
public class OAuthProfile {
    private Long id;
    private String connected_at;
    private Properties properties;
    private Kakao_account kakao_account;

    @Data
    public class Properties {
        private String nickname;
    }

    @Data
    public class Kakao_account {
        private Boolean profile_nickname_needs_agreement;
        private Profile profile;
        private Boolean has_email;
        private Boolean email_needs_agreement;
        private Boolean is_email_valid;
        private Boolean is_email_verified;
        private String email;

        @Data
        public class Profile {
            private String nickname;
        }
    }
}











