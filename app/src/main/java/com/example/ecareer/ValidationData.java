package com.example.ecareer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationData {
    public static boolean login_validate(String user_email,String user_password)
    {
        if (user_email.isEmpty() || user_password.isEmpty())
        {
            return false;
        }else
        {
            return true;
        }
    }

    public static boolean industry_validate(String user_email,String user_nic,String user_contact,String user_company,String user_password,String user_repassword)
    {
        if (user_email.isEmpty() || user_nic.isEmpty() || user_contact.isEmpty() || user_company.isEmpty() || user_password.isEmpty() || user_repassword.isEmpty())
        {
            return false;
        }else
        {
            return true;
        }
    }

    public static boolean student_validate(String user_email,String user_nic,String user_contact,String user_university,String user_id,String user_password,String user_repassword)
    {
        if (user_email.isEmpty() || user_nic.isEmpty() || user_contact.isEmpty() || user_university.isEmpty()||user_id.isEmpty() || user_password.isEmpty() || user_repassword.isEmpty())
        {
            return false;
        }else
        {
            return true;
        }
    }

    public static boolean student_update_validate(String user_email,String user_nic,String user_contact,String user_university,String user_id)
    {
        if (user_email.isEmpty() || user_nic.isEmpty() || user_contact.isEmpty() || user_university.isEmpty()||user_id.isEmpty())
        {
            return false;
        }else
        {
            return true;
        }
    }

    public static boolean check_password_validate(String password1,String password2)
    {
        if (password1.equals(password2))
        {
            return true;
        }else
        {
            return false;
        }
    }

    public static boolean isValidmail(final String email)
    {
        String StringTosearch = email;

        Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher m = p.matcher(StringTosearch);


        if (m.find())
            return true;
        else
            return false;
    }
    public static boolean isValidNic(final String nic) {

        String stringToSearch = nic;

        Pattern p = Pattern.compile("([0-9]{9}[a-z]{1})");
        Matcher m = p.matcher(stringToSearch);


        if (m.find() && nic.length()==10)
            return true;
        else
            return false;

    }

    public static boolean iscontact(final String contact)
    {
        String StringTosearch = contact;

        Pattern p = Pattern.compile("(^1300\\d{6}$)|(^0[1|3|7|6|8]{1}[0-9]{8}$)|(^13\\d{4}$)|(^04\\d{2,3}\\d{6}$)");
        Matcher m = p.matcher(StringTosearch);


        if (m.find())
            return true;
        else
            return false;
    }
}
