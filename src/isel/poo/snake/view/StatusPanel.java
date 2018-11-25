package isel.poo.snake.view;

import isel.poo.console.FieldView;
import isel.poo.console.ParentView;
import isel.poo.snake.model.Level;

public class StatusPanel extends ParentView {

    public static int WIDTH = 7;
    private FieldView fvLevel;
    private FieldView fvApples;
    private FieldView fvScore;

    public StatusPanel(int width){
        this.WIDTH = width;
        fvLevel = new FieldView("Level ",1, this.WIDTH, "1");
        fvApples = new FieldView("Apples",4, this.WIDTH, "1");
        fvScore = new FieldView("Score ",7, this.WIDTH, "1");

    }

    public void setLevel(int number) {
        fvLevel.setValue(number);
    }

    public void setApples(int remainingApples) {
        fvApples.setValue(remainingApples);
    }

    public void setScore(int score) {
        fvScore.setValue(score);
    }


}
