package task1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Users implements Serializable {
    private List<String> logins;
    private List<String> passwords;
    private List<String> genders;
    private List<String> phones;
    private List<String> emails;
    private List<String> subscribes;
    private static int i = 0;
    static StringBuilder stringBuilder = new StringBuilder();

    public Users() {
        this.logins = new ArrayList<>();
        this.passwords = new ArrayList<>();
        this.genders = new ArrayList<>();
        this.phones = new ArrayList<>();
        this.emails = new ArrayList<>();
        this.subscribes = new ArrayList<>();
    }

    void add(String login, String password, String gender, String phone, String email, String subscribe) {
        i++;
        logins.add(login);
        passwords.add(password);
        genders.add(gender);
        phones.add(phone);
        emails.add(email);
        subscribes.add(subscribe);
        stringBuilder.append("<tr>" +
                "<td>" + i + "</td>" +
                "<td>" + logins.get(i - 1) + "</td>" +
                "<td>" + passwords.get(i - 1) + "</td>" +
                "<td>" + genders.get(i - 1) + "</td>" +
                "<td>" + phones.get(i - 1) + "</td>" +
               "<td>" + emails.get(i - 1) + "</td>" +
                "<td>" + subscribes.get(i - 1) + "</td>" +
                "</tr>");
    }
}
