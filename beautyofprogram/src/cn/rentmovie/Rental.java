package cn.rentmovie;

public class Rental {
    private Movie _movie;
    private int _dayRented;

    public Rental(Movie _movie, int _dayRented) {
        this._movie = _movie;
        this._dayRented = _dayRented;
    }

    public Movie get_movie() {
        return _movie;
    }

    public void set_movie(Movie _movie) {
        this._movie = _movie;
    }

    public int get_dayRented() {
        return _dayRented;
    }

    public void set_dayRented(int _dayRented) {
        this._dayRented = _dayRented;
    }

     double getCharge(){
        double thisAmount = 0;

        // determine amounts for each line
        switch (get_movie().get_priveCode()){
            case Movie.REGULAR:
                thisAmount += 2;
                if (get_dayRented() > 2){
                    thisAmount += (get_dayRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += get_dayRented() * 3;
                break;
            case Movie.CHILDREN:
                thisAmount += 1.5;
                if (get_dayRented() > 3){
                    thisAmount += (get_dayRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }
}