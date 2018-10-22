package cs349.uwaterloo.ca.mvc2;

import java.util.Observable;
import java.util.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import static cs349.uwaterloo.ca.mvc2.Model.State.COMPUTER;
import static cs349.uwaterloo.ca.mvc2.Model.State.HUMAN;
import static cs349.uwaterloo.ca.mvc2.Model.State.LOSE;
import static cs349.uwaterloo.ca.mvc2.Model.State.START;
import static cs349.uwaterloo.ca.mvc2.Model.State.WIN;

// Based Upon: simon.h
class Model extends Observable {
    // Create static instance of this mModel
    private static final Model ourInstance = new Model();

    static Model getInstance() {
        return ourInstance;
    }

    // possible game states:
    // PAUSE - nothing happening
    // COMPUTER - computer is play a sequence of buttons
    // HUMAN - human is guessing the sequence of buttons
    // LOSE and WIN - game is over in one of thise states
    public enum State {START, COMPUTER, HUMAN, LOSE, WIN};

    // the game state and score
    private State state;
    private int score;

    // length of sequence
    private int length;
    // the sequence of buttons and current button
    private List<Integer> sequence = new ArrayList<>();
    private int index;

    private boolean debug;
    // number of possible buttons
    private String ButtonNumbers;
    private String Difficulty;

    Model() {
        ButtonNumbers = "4";
        Difficulty = "Normal";
        debug = true;
        length = 1;
        state = START;
        score = 0;
        if (debug) {
            System.out.println("[DEBUG] starting " + Integer.parseInt(ButtonNumbers) + " button game");
        }
    }

    public void Save(String buttons, String difficulty){
        ButtonNumbers = buttons;
        Difficulty = difficulty;
        setChanged();
        notifyObservers();
    }

    public String getButtonNumbers(){
        return ButtonNumbers;
    }

    public String getDifficulty(){
        return Difficulty;
    }

    public int getScore() {
        return score;
    }

    public State getState() {
        return state;
    }

    public String getStateAsString() {
        switch (getState()) {
            case START:
                return "START";
            case COMPUTER:
                return "COMPUTER";
            case HUMAN:
                return "HUMAN";
            case LOSE:
                return "LOSE";
            case WIN:
                return "WIN";
            default:
                return "Unkown State";
        }
    }

    public void newRound() {
        if (debug) {
            System.out.println("[DEBUG] newRound, Simon::state " + getStateAsString());
        }

        // reset if they lost last time
        if (state == LOSE) {
            if (debug) {
                System.out.println("[DEBUG] reset length and score after loss");
            }
            length = 1;
            score = 0;
        }
        sequence.clear();
        if (debug) {
            System.out.println("[DEBUG] new sequence: ");
        }
        for (int i = 0; i < length; i++) {
            //int b = (int)Math.random() * (buttons + 1);
            int b = new Random().nextInt(Integer.parseInt(ButtonNumbers));
            sequence.add(b);
            if (debug) {
                System.out.println(b);
            }
        }
        if (debug) { System.out.println(); }
        index = 0;
        state = COMPUTER;
    }

    // call this to get next button to show when computer is playing
    public int nextButton() {
        if (state != COMPUTER) {
            System.out.println("[WARNING] nextButton called in " + getStateAsString());
            return -1;
        }

        // this is the next button to show in the sequence
        int button = sequence.get(index);
        if (debug) {
            System.out.println("[DEBUG] nextButton:  index " + index + " button " + button);
        }

        // advance to next button
        index++;

        // if all the buttons were shown, give
        // the human a chance to guess the sequence
        if (index >= sequence.size()) {
            index = 0;
            state = HUMAN;
        }
        return button;
    }

    public boolean verifyButton(int button) {
        if (state != HUMAN) {
            System.out.println("[WARNING] verifyButton called in " + getStateAsString());
            return false;
        }
        // did they press the right button?
        boolean correct = (button == sequence.get(index));
        if (debug) {
            System.out.println("[DEBUG] verifyButton: index " + index + ", pushed " + button + ", sequence " + sequence.get(index));
        }
        // advance to next button
        index++;
        // pushed the wrong buttons
        if (!correct) {
            state = LOSE;
            if (debug) {
                System.out.println(", wrong. ");
                System.out.println("[DEBUG] state is now " + getStateAsString());
            }
            // they got it right
        } else {
            if (debug) {
                System.out.println(", correct.");
            }
            // if last button, then the win the round
            if (index == sequence.size()) {
                state = WIN;
                // update the score and increase the difficulty
                score++;
                length++;
                if (debug) {
                    System.out.println("[DEBUG] state is now " + getStateAsString());
                    System.out.println("[DEBUG] new score " + score + ", length increased to " + length);
                }
            }
        }
        return correct;
    }

    public void initObservers()
    {
        setChanged();
        notifyObservers();
    }

    @Override
    public synchronized void deleteObserver(Observer o)
    {
        super.deleteObserver(o);
    }
    @Override
    public synchronized void addObserver(Observer o)
    {
        super.addObserver(o);
    }
    @Override
    public synchronized void deleteObservers()
    {
        super.deleteObservers();
    }
    @Override
    public void notifyObservers()
    {
        super.notifyObservers();
    }
}
