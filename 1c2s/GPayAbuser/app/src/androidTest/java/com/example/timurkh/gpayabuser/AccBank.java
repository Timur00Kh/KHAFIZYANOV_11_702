package com.example.timurkh.gpayabuser;

import java.util.ArrayList;
import java.util.List;

public class AccBank {
    List<Acc> accs = new ArrayList<>();

    private class Acc {
        private String EMail;
        private String pass;

        public Acc(String eMail, String pass) {
            this.EMail = eMail;
            this.pass = pass;
        }

        public String getEMail() {
            return EMail;
        }

        public String getPass() {
            return pass;
        }
    }

    public AccBank(String s) {
        String[] ss = s.split(" ");
        for (int i = 0; i < ss.length; i++){
            accs.add(new Acc(ss[i],ss[++i]));
        }
    }

    public int getSize() {
        return accs.size();
    }

    public String getEMail(int i) {
        return accs.get(i).getEMail();
    }

    public String getPass(int i) {
        return accs.get(i).getPass();
    }
}
