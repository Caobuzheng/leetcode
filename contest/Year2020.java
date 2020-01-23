public class Year2020 {
    public static void main(String[] args) {
        Year2020 y = new Year2020();
        y.xx(2);
        
    }


    


    public static void ttt() {
        Year2020 y = new Year2020();
        System.out.println(y.canVillagersWin(new String[]{"bear","vil","vil","ww","vil","vil","idiot","ww","hunter","ww","ww","vil"},
                            new int[]{9,55,62,74,43,70,13,23,15,78,61,66}) == false);

       
        System.out.println(y.canVillagersWin(new String[]{"vil", "vil", "vil", "ww", "vil", "ww", "ww", "vil", "ww", "bear", "hunter", "idiot"},
         new int[]{81, 71, 88, 31, 34, 40, 70, 94, 73, 79, 98, 48}) == true);

        System.out.println(y.canVillagersWin(new String[]{"vil","ww","bear","hunter","ww","idiot","vil","vil","ww","vil","ww","vil"},
         new int[]{45,67,32,25,1,27,99,85,3,54,3,25}) == true);
    } 

    public boolean canVillagersWin(String[] players, int[] credibility) {
        int ww = 4;
        int good = 8;
        int xbeer = -1;
        int beer = -1;
        int idiot = -1;
        int hardWolf = -1;
        boolean[] real = new boolean[12];
        boolean[] maybad = new boolean[12];

        for(int i = 0;i<players.length;i++) {
            if(players[i].equals("ww")) {
                credibility[i] = -credibility[i];
            }
        }

        for(int i = 0;i<players.length;i++) {
            if(players[i].equals("bear")) {
                beer = i;
                break;
            }
        }

        while(ww!=0 && ww<good) {
            int kill = -1;
            int cred = 0;

            if(xbeer != -1 && credibility[xbeer] != 0) {
                kill = xbeer;
            }else {
                for(int i=0;i<credibility.length;i++) {
                    if(credibility[i] > cred) {
                        cred = credibility[i];
                        kill = i;
                    }
                }
            }

            good--;
            credibility[kill] = 0;
            real[kill] = true;

            if(maybad[kill]) {
                for(int i = 0;i<12;i++) {
                    if(i == kill) continue;
                    if(maybad[i] && credibility[i] != 0) {
                        hardWolf = i;
                    } 
                }
            }
            
            
            int wangwang = 0;
            int l = -1;
            int r = -1;
            // 咆哮。当晚被杀的玩家也视为死亡
            int wangHardWolf = -1;
            if(credibility[beer] > 0) {
                l = (beer-1+12) % 12;
                while(credibility[l] == 0) {
                    l = (l-1+12) % 12;
                }
                r = (beer+1+12) % 12;
                while(credibility[r] == 0) {
                    r = (r+1+12) % 12;
                }
                if(credibility[l] < 0 || credibility[r] < 0) {
                    wangwang = 1;
                    if(real[l]) {
                        wangHardWolf = r;
                    }
                    if(real[r]) {
                        wangHardWolf = l;
                    }
                }
            }


            // 咆哮完了，如果是猎人死了，开始杀人。
            if(players[kill].equals("hunter")) {
                int hKill = -1;
                int hCred = 200;
                // 肯定先杀
                if(hardWolf != -1 && credibility[hardWolf] != 0) {
                    hKill = hardWolf;
                }else {
                    for(int i = 0;i<12;i++) {
                        if(credibility[i] == 0) continue;
                        if(real[i]) continue;// 铁好人也不杀。
                        if(Math.abs(credibility[i]) < hCred) {
                            hKill = i;
                            hCred = Math.abs(credibility[i]);
                        }
                    }
                }
                if(credibility[hKill] < 0) {
                    ww--;
                }else {
                    good--;
                }
                credibility[hKill] = 0;
            }


            if(ww==0 || ww>=good) {
                break;
            }

             // 如果熊还活着。熊表明身份。
             if(credibility[beer] != 0) {
                real[beer] = true;
                if(wangHardWolf != -1) {
                    hardWolf = wangHardWolf;
                }
                xbeer = beer;
                if(wangwang == 0) {
                    real[l] = true;
                    real[r] = true;
                }
                if(wangwang == 1) {
                    maybad[l] = true;
                    maybad[r] = true;
                    if(Math.abs(credibility[l]) != 1) {
                        credibility[l] /= 2;
                    }
                    if(Math.abs(credibility[r]) != 1) {
                        credibility[r] /= 2;
                    }
                }
            }

            if(l!= -1 && real[l] && maybad[l]) {
                for(int i = 0;i<12;i++) {
                    if(i == l) continue;
                    if(maybad[i] && credibility[i] != 0) {
                        hardWolf = i;
                    } 
                }
            }

            if(r != -1 && real[r] && maybad[r]) {
                for(int i = 0;i<12;i++) {
                    if(i == r) continue;
                    if(maybad[i] && credibility[i] != 0) {
                        hardWolf = i;
                    } 
                }
            }


            // 投票
            int dKill = -1;
            int dCred = 100;
            if(hardWolf != -1 && credibility[hardWolf] != 0) {
                dKill = hardWolf;
            }else {
                for(int i =0;i<credibility.length;i++) {
                    if(credibility[i] == 0) continue;
                    if(real[i]) continue;
                    int cc = Math.abs(credibility[i]);
                    if(cc < dCred) {
                        dKill = i;
                        dCred = cc;
                    }
                }
            }
            // 投死的是白痴。
            if(credibility[dKill] < 0) {
                ww--;
                credibility[dKill] = 0;
            }else if (!players[dKill].equals("idiot")){
                good--;
                credibility[dKill] = 0;
            }else {
                real[dKill] = true; // 
            }

            if(players[dKill].equals("hunter")) {
                real[dKill] = true;
            }

            if(maybad[dKill] && real[dKill]) {
                for(int i = 0;i<12;i++) {
                    if(i == dKill) continue;
                    if(maybad[i] && credibility[i] != 0) {
                        hardWolf = i;
                    } 
                }
            }

            if(players[dKill].equals("hunter")) {
                int hKill = -1;
                int hCred = 100;
                if(hardWolf != -1 && credibility[hardWolf] != 0) {
                    hKill = hardWolf;
                }else {
                    for(int i = 0;i<12;i++) {
                        if(credibility[i] == 0) continue;
                        if(real[i]) continue;// 铁好人也不杀。
                        if(Math.abs(credibility[i]) < hCred) {
                            hKill = i;
                            hCred = Math.abs(credibility[i]);
                        }
                    }
                }
                if(credibility[hKill] < 0) {
                    ww--;
                }else {
                    good--;
                }
                credibility[hKill] = 0;
            }
        }
        return ww<good;
    }







    class Solution {
        public String q() {
            return "class Solution {"+
            "public String q() {"+
                    ""+
                "}" +
            "}";
        }
    }

    // 模拟。
    public int findNum(int n, int k) {
        int MOD = 1000000007;
        // int x = 0;
        // int y = k;
        int x = 0;
        while(x<1000000) {
            int y = x;
            int i = 0;
            for(;i<n;i++) {
                if((n * y +k)% (n-k) != 0) {
                    break;
                }
                y = (y*n+k)/(n-k);
            }
            if(i != n) {
                x++;
            }else {
                return (y%MOD*n+k)%MOD;
            }
        }
        return -1;

    }
}