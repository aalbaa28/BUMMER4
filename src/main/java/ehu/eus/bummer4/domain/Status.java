package ehu.eus.bummer4.domain;

import java.util.ArrayList;
import java.util.List;

public class Status {

    String id;

    String created_at;

    String content;

    Status reblog;

    Account account;

    List<Media_Attachments> media_attachments ;

    @Override
    public String toString() {
        return "Status{" +
                "id='" + id + '\'' +
                ", created_at='" + created_at + '\'' +
                ", content='" + content + '\'' +
                ", reblog=" + reblog +
                ", account=" + account +
                '}';
    }
    public class Media_Attachments{

        String url;

        public String getUrl() {
            return url;
        }

        @Override
        public String toString() {
            return "Media_Attachments{" +
                    "url='" + url + '\'' + '}';
        }


    }
    public class Account{
        String id;
        String username;
        String acct;
        String display_name;
        Boolean locked;

        @Override
        public String toString() {
            return "Account{" +
                    "id='" + id + '\'' +
                    ", username='" + username + '\'' +
                    ", acct='" + acct + '\'' +
                    ", display_name='" + display_name + '\'' +
                    ", locked=" + locked +
                    '}';
        }

        public String getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getAcct() {
            return acct;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public Boolean getLocked() {
            return locked;
        }
    }

    public String getId() {
        return id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getContent() {
        return content;
    }

    public Status getReblog() {
        return reblog;
    }

    public Account getAccount() {
        return account;
    }


    public List<Media_Attachments> getMediaAttachments() {
        return media_attachments;
    }

}
