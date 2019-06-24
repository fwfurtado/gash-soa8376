package br.com.caelum.gash.user.commons;

public enum Topics implements NameableTopic {
    USER {
        @Override
        public String getTopicName() {
            return "users";
        }
    }
}
