package jazz;

/**
 * Created by user on 10.11.2017.
 */
class WritableSumm extends AbstractWritableSumm {
    final String[][] str1 = {
            {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
    };
    final String[] str100 = {"", "сто", "двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    String[] str11 = {"", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать",
            "двадцать"};
    String[] str10 = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят",
            "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    final String[][] forms = {
            {"", "", "", "0"},
            {"", "", "", "0"},
            {"тысяча", "тысячи", "тысяч", "1"},
            {"миллион", "миллиона", "миллионов", "0"},
            {"миллиард", "миллиарда", "миллиардов", "0"},
            {"триллион", "триллиона", "триллионов", "0"},
    };

    protected String getS1(int n, int gender) {
        return str1[gender][n];
    }

    protected String getS11(int n) {
        return str11[n];
    }

    protected String getS10(int n) {
        return str10[n];
    }

    protected String getS100(int n) {
        return str100[n];
    }

    protected int getUnitGender(int idx) {
        return new Integer(forms[idx][3]);
    }

    protected String getUnit(int idx, long cnt) {
        if (cnt % 100 > 4 && cnt % 100 < 21)
            return forms[idx][2];
        switch ((int) (cnt % 10)) {
            case 1:
                return forms[idx][0];
            case 2:
            case 3:
            case 4:
                return forms[idx][1];
            default:
                return forms[idx][2];
        }
    }

    // главный метод
    public String numberToString(Number num) {
        String res = "";
        if (num.longValue() == 0) {
            res = getS1(0, 0) + " " + getUnit(1, 0);
        }
        int idx = 0;
        num = num.longValue() * 1000 + (long) ((num.doubleValue() - num.longValue()) * 100);
        while (num.longValue() > 0) {
            String triad = triadToString((int) (num.longValue() % 1000), getUnitGender(idx), idx < 1);
            res = triad + getUnit(idx, num.longValue() % 1000) + " " + res;
            num = num.longValue() / 1000;
            idx++;
        }
        return res;
    }
}