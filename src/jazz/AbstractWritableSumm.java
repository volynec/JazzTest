package jazz;

/**
 * Created by user on 10.11.2017.
 */
abstract class AbstractWritableSumm {
    // получение единиц, 11-19, десятков, сотен
    abstract protected String getS1(int n, int gender);

    abstract protected String getS11(int n);

    abstract protected String getS10(int n);

    abstract protected String getS100(int n);

    // преобразование триады в слова
    protected String triadToString(int n, int gender, boolean acceptZero) {
        if (!acceptZero && n == 0) return "";
        String res = "";
        if (n % 1000 > 99) {
            res += getS100(n % 1000 / 100) + " ";
        }
        if (n % 100 > 10 && n % 100 < 20) {
            return res + getS11(n % 10) + " ";
        }
        if (n % 100 > 9) {
            res += getS10(n % 100 / 10) + " ";
        }
        if (res.length() == 0 || n % 10 > 0) {
            res = res + getS1(n % 10, gender) + " ";
        }
        return res;
    }

    // получение юнита (название триады)
    abstract protected String getUnit(int idx, long count);

    // форма юнита (пол)
    abstract protected int getUnitGender(int idx);


}
