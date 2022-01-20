package cn.rentmovie;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priveCode;



    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public int get_priveCode() {
        return _priveCode;
    }

    public void set_priveCode(int _priveCode) {
        this._priveCode = _priveCode;
    }
}
