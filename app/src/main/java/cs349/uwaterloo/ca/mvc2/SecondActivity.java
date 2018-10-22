package cs349.uwaterloo.ca.mvc2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

// Based Upon: Android/MVC2
public class SecondActivity extends AppCompatActivity implements Observer{
    private Button circle1, circle2, circle3, circle4, circle5, circle6, circle7,
                    circle8, circle9, circle10, circle11, circle12, circle13, circle14,
                    circle15, circle16, circle17, circle18, circle19, circle20, circle21;

    private TextView message;
    private TextView score;

    private Button back;
    private Button setting;

    private int CircleNumber;
    Handler handler = new Handler();

    private boolean ButtonPress = false;

    Model model;

    /**
     * OnCreate is Called when application is initially launched.
     */
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        // Get Model instance
        model = Model.getInstance();
        model.addObserver(this);

        // set message button references
        message = (TextView) findViewById(R.id.game_message);
        message.setText("Press Here to Play");

        // set score button references
        score = (TextView) findViewById(R.id.game_score);
        score.setText("Current Score: " + model.getScore());

        // set circle button references
        circle1 = (Button) findViewById(R.id.push_button1);
        circle2 = (Button) findViewById(R.id.push_button2);
        circle3 = (Button) findViewById(R.id.push_button3);
        circle4 = (Button) findViewById(R.id.push_button4);
        circle5 = (Button) findViewById(R.id.push_button5);
        circle6 = (Button) findViewById(R.id.push_button6);
        circle7 = (Button) findViewById(R.id.push_button7);
        circle8 = (Button) findViewById(R.id.push_button8);
        circle9 = (Button) findViewById(R.id.push_button9);
        circle10 = (Button) findViewById(R.id.push_button10);
        circle11 = (Button) findViewById(R.id.push_button11);
        circle12 = (Button) findViewById(R.id.push_button12);
        circle13 = (Button) findViewById(R.id.push_button13);
        circle14 = (Button) findViewById(R.id.push_button14);
        circle15 = (Button) findViewById(R.id.push_button15);
        circle16 = (Button) findViewById(R.id.push_button16);
        circle17 = (Button) findViewById(R.id.push_button17);
        circle18 = (Button) findViewById(R.id.push_button18);
        circle19 = (Button) findViewById(R.id.push_button19);
        circle20 = (Button) findViewById(R.id.push_button20);
        circle21 = (Button) findViewById(R.id.push_button21);

        // get number of buttons
        int buttonNumber = Integer.parseInt(model.getButtonNumbers());

        // some buttons are invisible depends on number of buttons
        if (buttonNumber == 1) {
            circle2.setVisibility(View.GONE);
            circle3.setVisibility(View.GONE);
            circle4.setVisibility(View.GONE);
            circle5.setVisibility(View.GONE);
            circle6.setVisibility(View.GONE);
            circle7.setVisibility(View.GONE);
            circle8.setVisibility(View.GONE);
            circle9.setVisibility(View.GONE);
            circle10.setVisibility(View.GONE);
            circle11.setVisibility(View.GONE);
            circle12.setVisibility(View.GONE);
            circle13.setVisibility(View.GONE);
            circle14.setVisibility(View.GONE);
            circle15.setVisibility(View.GONE);
            circle16.setVisibility(View.GONE);
            circle17.setVisibility(View.GONE);
            circle18.setVisibility(View.GONE);
            circle19.setVisibility(View.GONE);
            circle20.setVisibility(View.GONE);
            circle21.setVisibility(View.GONE);
        } else if (buttonNumber == 2){
            circle1.setVisibility(View.GONE);
            circle4.setVisibility(View.GONE);
            circle5.setVisibility(View.GONE);
            circle6.setVisibility(View.GONE);
            circle7.setVisibility(View.GONE);
            circle8.setVisibility(View.GONE);
            circle9.setVisibility(View.GONE);
            circle10.setVisibility(View.GONE);
            circle11.setVisibility(View.GONE);
            circle12.setVisibility(View.GONE);
            circle13.setVisibility(View.GONE);
            circle14.setVisibility(View.GONE);
            circle15.setVisibility(View.GONE);
            circle16.setVisibility(View.GONE);
            circle17.setVisibility(View.GONE);
            circle18.setVisibility(View.GONE);
            circle19.setVisibility(View.GONE);
            circle20.setVisibility(View.GONE);
            circle21.setVisibility(View.GONE);
        } else if (buttonNumber == 3){
            circle1.setVisibility(View.GONE);
            circle2.setVisibility(View.GONE);
            circle3.setVisibility(View.GONE);
            circle7.setVisibility(View.GONE);
            circle8.setVisibility(View.GONE);
            circle9.setVisibility(View.GONE);
            circle10.setVisibility(View.GONE);
            circle11.setVisibility(View.GONE);
            circle12.setVisibility(View.GONE);
            circle13.setVisibility(View.GONE);
            circle14.setVisibility(View.GONE);
            circle15.setVisibility(View.GONE);
            circle16.setVisibility(View.GONE);
            circle17.setVisibility(View.GONE);
            circle18.setVisibility(View.GONE);
            circle19.setVisibility(View.GONE);
            circle20.setVisibility(View.GONE);
            circle21.setVisibility(View.GONE);
        } else if (buttonNumber == 4){
            circle1.setVisibility(View.GONE);
            circle2.setVisibility(View.GONE);
            circle3.setVisibility(View.GONE);
            circle4.setVisibility(View.GONE);
            circle5.setVisibility(View.GONE);
            circle6.setVisibility(View.GONE);
            circle11.setVisibility(View.GONE);
            circle12.setVisibility(View.GONE);
            circle13.setVisibility(View.GONE);
            circle14.setVisibility(View.GONE);
            circle15.setVisibility(View.GONE);
            circle16.setVisibility(View.GONE);
            circle17.setVisibility(View.GONE);
            circle18.setVisibility(View.GONE);
            circle19.setVisibility(View.GONE);
            circle20.setVisibility(View.GONE);
            circle21.setVisibility(View.GONE);
        } else if (buttonNumber == 5){
            circle1.setVisibility(View.GONE);
            circle2.setVisibility(View.GONE);
            circle3.setVisibility(View.GONE);
            circle4.setVisibility(View.GONE);
            circle5.setVisibility(View.GONE);
            circle6.setVisibility(View.GONE);
            circle7.setVisibility(View.GONE);
            circle8.setVisibility(View.GONE);
            circle9.setVisibility(View.GONE);
            circle10.setVisibility(View.GONE);
            circle16.setVisibility(View.GONE);
            circle17.setVisibility(View.GONE);
            circle18.setVisibility(View.GONE);
            circle19.setVisibility(View.GONE);
            circle20.setVisibility(View.GONE);
            circle21.setVisibility(View.GONE);
        } else {
            circle1.setVisibility(View.GONE);
            circle2.setVisibility(View.GONE);
            circle3.setVisibility(View.GONE);
            circle4.setVisibility(View.GONE);
            circle5.setVisibility(View.GONE);
            circle6.setVisibility(View.GONE);
            circle7.setVisibility(View.GONE);
            circle8.setVisibility(View.GONE);
            circle9.setVisibility(View.GONE);
            circle10.setVisibility(View.GONE);
            circle11.setVisibility(View.GONE);
            circle12.setVisibility(View.GONE);
            circle13.setVisibility(View.GONE);
            circle14.setVisibility(View.GONE);
            circle15.setVisibility(View.GONE);
        }

        // Create controller to display messages
        message.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                message.setText("Watch What should I do");

                model.newRound();

                score.setText("Current Score: " + model.getScore());

                int delay = 0;
                int adddelay;

                // change speed depending on difficulty
                if (model.getDifficulty().equals("Easy")){
                    adddelay = 1000;
                } else if (model.getDifficulty().equals("Normal")){
                    adddelay = 600;
                } else {
                    adddelay = 400;
                }

                // the circle turn black first, then back to original color after a short delay
                while (model.getState() == Model.State.COMPUTER){

                    delay = delay + adddelay;

                    int next = model.nextButton();

                    int buttonNumber = Integer.parseInt(model.getButtonNumbers());

                    if (buttonNumber == 1) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                circle1.setBackgroundResource(R.drawable.roundblack);
                            }
                        }, delay - adddelay / 2);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                circle1.setBackgroundResource(R.drawable.roundedbutton);
                            }
                        }, delay);
                    } else if (buttonNumber == 2) {
                        if (next == 0) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle2.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        } else {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle3.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        }
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                circle2.setBackgroundResource(R.drawable.roundedbutton);
                                circle3.setBackgroundResource(R.drawable.roundedbutton);
                            }
                        }, delay);
                    } else if (buttonNumber == 3) {
                        if (next == 0) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle4.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        } else if (next == 1) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle5.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        } else {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle6.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        }
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                circle4.setBackgroundResource(R.drawable.roundedbutton);
                                circle5.setBackgroundResource(R.drawable.roundedbutton);
                                circle6.setBackgroundResource(R.drawable.roundedbutton);
                            }
                        }, delay);
                    } else if (buttonNumber == 4) {
                        if (next == 0) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle7.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        } else if (next == 1) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle8.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        } else if (next == 2) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle9.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        } else {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle10.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        }
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                circle7.setBackgroundResource(R.drawable.roundedbutton);
                                circle8.setBackgroundResource(R.drawable.roundedbutton);
                                circle9.setBackgroundResource(R.drawable.roundedbutton);
                                circle10.setBackgroundResource(R.drawable.roundedbutton);
                            }
                        }, delay);
                    } else if (buttonNumber == 5) {
                        if (next == 0) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle11.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        } else if (next == 1){
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle12.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        } else if (next == 2){
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle13.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        } else if (next == 3){
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle14.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        } else {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle15.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        }
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                circle11.setBackgroundResource(R.drawable.roundedbutton);
                                circle12.setBackgroundResource(R.drawable.roundedbutton);
                                circle13.setBackgroundResource(R.drawable.roundedbutton);
                                circle14.setBackgroundResource(R.drawable.roundedbutton);
                                circle15.setBackgroundResource(R.drawable.roundedbutton);
                            }
                        }, delay);
                    } else {
                        if (next == 0) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle16.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        } else if (next == 1){
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle17.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        } else if (next == 2){
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle18.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        } else if (next == 3){
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle19.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        } else if (next == 4){
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle20.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        } else {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    circle21.setBackgroundResource(R.drawable.roundblack);
                                }
                            }, delay - adddelay / 2);
                        }
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                circle16.setBackgroundResource(R.drawable.roundedbutton);
                                circle17.setBackgroundResource(R.drawable.roundedbutton);
                                circle18.setBackgroundResource(R.drawable.roundedbutton);
                                circle19.setBackgroundResource(R.drawable.roundedbutton);
                                circle20.setBackgroundResource(R.drawable.roundedbutton);
                                circle21.setBackgroundResource(R.drawable.roundedbutton);
                            }
                        }, delay);
                    }

                }

                // this message is showed when all animations are finished
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        message.setText("Now it’s your turn");
                        ButtonPress = true;
                    }
                }, delay);
            }
        });

        // Create controller to click circle
        circle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 0;
                    circle1.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle1.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 0;
                    circle2.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle2.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 1;
                    circle3.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle3.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 0;
                    circle4.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle4.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 1;
                    circle5.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle5.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 2;
                    circle6.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle6.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 0;
                    circle7.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle7.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 1;
                    circle8.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle8.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 2;
                    circle9.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle9.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 3;
                    circle10.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle10.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 0;
                    circle11.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle11.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 1;
                    circle12.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle12.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 2;
                    circle13.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle13.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 3;
                    circle14.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle14.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 4;
                    circle15.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle15.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 0;
                    circle16.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle16.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 1;
                    circle17.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle17.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 2;
                    circle18.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle18.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 3;
                    circle19.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle19.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 4;
                    circle20.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle20.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        circle21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ButtonPress){
                    CircleNumber = 5;
                    circle21.setBackgroundResource(R.drawable.roundblack);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circle21.setBackgroundResource(R.drawable.roundedbutton);
                        }
                    }, 200);

                    if (!model.verifyButton(CircleNumber)) {
                    }
                    model.initObservers();
                }
            }
        });

        back = (Button) findViewById(R.id.game_back);

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent myIntent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });

        setting = (Button) findViewById(R.id.game_back_setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SecondActivity.this, SettingActivity.class);
                startActivity(myIntent);
            }
        });
        model.initObservers();

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        // Remove observer when activity is destroyed.
        model.deleteObserver(this);
    }


    /**
     * This method is called whenever the observed object is changed.
     */
    @Override
    public void update(Observable o, Object arg) {
        // need to check the state of game every time
        switch (model.getState()){
            case WIN:
                message.setText("You won! Press Here to continue");
                score.setText("Current Score: " + model.getScore());
                ButtonPress = false;
                break;
            case LOSE:
                message.setText("You lose. Press Here to play again");
                score.setText("Your Score: " + model.getScore());
                ButtonPress = false;
                break;
            default:
                break;
        }
    }
}