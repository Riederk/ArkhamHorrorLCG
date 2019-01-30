package com.whitdan.arkhamhorrorlcgcampaignguide.C_Scenario;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.MainMenuActivity;
import com.whitdan.arkhamhorrorlcgcampaignguide.R;
import com.whitdan.arkhamhorrorlcgcampaignguide.Z_Data.GlobalVariables;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class ScenarioIntroductionActivity extends AppCompatActivity {

    static GlobalVariables globalVariables;
    static boolean progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // If app is reopening after the process is killed, kick back to the main menu (stops the activity from
        // showing up unpopulated)
        if (savedInstanceState != null) {
            Intent intent = new Intent(ScenarioIntroductionActivity.this, MainMenuActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_activity_scenario_introduction);
        globalVariables = (GlobalVariables) this.getApplication();
        progress = false;

        // Set title
        TextView title = findViewById(R.id.current_scenario_name);
        Typeface teutonic = Typeface.createFromAsset(getAssets(), "fonts/teutonic.ttf");
        title.setTypeface(teutonic);
        globalVariables.setTitle(title);

        // Set typefaces
        TextView introduction = findViewById(R.id.introduction_text);
        TextView introductionA = findViewById(R.id.introduction_text_one);
        TextView introductionB = findViewById(R.id.introduction_text_two);
        TextView introductionC = findViewById(R.id.introduction_text_three);
        Typeface arnoproitalic = Typeface.createFromAsset(getAssets(), "fonts/arnoproitalic.otf");
        introduction.setTypeface(arnoproitalic);
        introductionA.setTypeface(arnoproitalic);
        introductionB.setTypeface(arnoproitalic);
        introductionC.setTypeface(arnoproitalic);
        final TextView introductionOne = findViewById(R.id.introduction_text_additional_one);
        final TextView introductionTwo = findViewById(R.id.introduction_text_additional_two);
        TextView introductionThree = findViewById(R.id.introduction_text_additional_three);
        TextView introductionFour = findViewById(R.id.introduction_text_additional_four);
        TextView introductionFive = findViewById(R.id.introduction_text_additional_five);
        TextView introductionSix = findViewById(R.id.introduction_text_additional_six);
        introductionOne.setTypeface(arnoproitalic);
        introductionTwo.setTypeface(arnoproitalic);
        introductionThree.setTypeface(arnoproitalic);
        introductionFour.setTypeface(arnoproitalic);
        introductionFive.setTypeface(arnoproitalic);
        introductionSix.setTypeface(arnoproitalic);
        RadioGroup introductionOptions = findViewById(R.id.introduction_options);
        RadioButton introductionOptionOne = findViewById(R.id.introduction_option_one);
        RadioButton introductionOptionTwo = findViewById(R.id.introduction_option_two);
        RadioButton introductionOptionThree = findViewById(R.id.introduction_option_three);
        RadioButton introductionOptionFour = findViewById(R.id.introduction_option_four);
        Typeface arnopro = Typeface.createFromAsset(getAssets(), "fonts/arnopro.otf");
        introductionOptionOne.setTypeface(arnopro);
        introductionOptionTwo.setTypeface(arnopro);
        final RadioGroup additionalOptions = findViewById(R.id.introduction_additional_options);
        final RadioButton additionalOptionOne = findViewById(R.id.introduction_additional_option_one);
        final RadioButton additionalOptionTwo = findViewById(R.id.introduction_additional_option_two);
        additionalOptionOne.setTypeface(arnopro);
        additionalOptionTwo.setTypeface(arnopro);

        // Set text
        switch (globalVariables.CurrentCampaign) {
            case 1:
                switch (globalVariables.CurrentScenario) {
                    case 1:
                        introduction.setText(R.string.gathering_introduction);
                        break;
                    case 2:
                        if (globalVariables.LitaChantler == 2) {
                            introduction.setText(R.string.midnight_introduction_one);
                        } else {
                            introduction.setText(R.string.midnight_introduction_two);
                        }
                        break;
                    case 3:
                        introduction.setText(R.string.devourer_introduction);
                        break;
                }
                break;
            case 2:
                switch (globalVariables.CurrentScenario) {
                    case 1:
                        introduction.setText(R.string.extracurricular_introduction);
                        break;
                    case 2:
                        introduction.setText(R.string.house_introduction);
                        break;
                    case 4:
                        if (globalVariables.HenryArmitage == 0) {
                            introduction.setText(R.string.miskatonic_introduction_one);
                        } else {
                            introduction.setText(R.string.miskatonic_introduction_two);
                        }
                        break;
                    case 5:
                        introduction.setText(R.string.essex_introduction);
                        break;
                    case 6:
                        introduction.setText(R.string.blood_introduction);
                        break;
                    case 8:
                        introduction.setText(R.string.undimensioned_introduction);
                        introductionOptions.setVisibility(VISIBLE);
                        introductionOptionOne.setText(R.string.undimensioned_introduction_option_one);
                        introductionOptionTwo.setText(R.string.undimensoned_introduction_option_two);
                        globalVariables.TownsfolkAction = 0;
                        introductionOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                                introductionOne.setVisibility(VISIBLE);
                                switch (i) {
                                    case R.id.introduction_option_one:
                                        globalVariables.TownsfolkAction = 1;
                                        introductionOne.setText(R.string.undimensioned_introduction_one);
                                        break;
                                    case R.id.introduction_option_two:
                                        globalVariables.TownsfolkAction = 2;
                                        introductionOne.setText(R.string.undimensioned_introduction_two);
                                        break;
                                }
                            }
                        });
                        break;
                    case 9:
                        if (globalVariables.ObannionGang == 0) {
                            introduction.setText(R.string.doom_introduction_one);
                        } else {
                            introduction.setText(R.string.doom_introduction_two);
                        }
                        break;
                    case 10:
                        introduction.setText(R.string.lost_introduction);
                        break;
                    case 11:
                        if (globalVariables.TownsfolkAction == 1) {
                            introduction.setText(R.string.dunwich_epilogue_one);
                        } else if (globalVariables.TownsfolkAction == 2) {
                            introduction.setText(R.string.dunwich_epilogue_two);
                        }
                        break;
                }
                break;
            case 3:
                switch (globalVariables.CurrentScenario) {
                    case 1:
                        introduction.setText(R.string.curtain_introduction);
                        break;
                    case 2:
                        introduction.setText(R.string.king_introduction);
                        break;
                    case 4:
                        if (globalVariables.Sebastien == 1 || globalVariables.Sebastien == 4) {
                            introduction.setText(R.string.echoes_introduction_two);
                        } else {
                            introduction.setText(R.string.echoes_introduction);
                        }
                        break;
                    case 5:
                        if (globalVariables.Onyx == 4) {
                            introduction.setText(R.string.unspeakable_introduction_one);
                        } else {
                            introduction.setText(R.string.unspeakable_introduction_two);
                        }
                        if (globalVariables.Constance == 1 || globalVariables.Constance == 4) {
                            introductionOne.setVisibility(VISIBLE);
                            introductionOne.setText(R.string.unspeakable_introduction_constance);
                        }
                        break;
                    case 7:
                        if (globalVariables.Asylum == 1) {
                            introduction.setText(R.string.dream_one_one);
                        } else {
                            introduction.setText(R.string.dream_one_two);
                        }
                        if (globalVariables.Asylum == 1) {
                            introductionB.setVisibility(VISIBLE);
                            introductionB.setText(R.string.dream_eight);
                        } else {
                            introductionA.setVisibility(VISIBLE);
                            introductionB.setVisibility(VISIBLE);
                            if (globalVariables.Party == 1) {
                                introductionA.setText(R.string.dream_three_six);
                            } else if (globalVariables.Party == 3) {
                                introductionA.setText(R.string.dream_four_six);
                                if (globalVariables.DreamsAction == 0) {
                                    for (int i = 0; i < globalVariables.Investigators.size(); i++) {
                                        globalVariables.Investigators.get(i).Horror += 1;
                                    }
                                }
                            } else {
                                introductionA.setText(R.string.dream_six);
                            }
                            if (globalVariables.Police == 2) {
                                introductionB.setText(R.string.dream_seven_eight);
                            } else {
                                introductionB.setText(R.string.dream_eight);
                            }
                        }
                        introductionC.setVisibility(VISIBLE);
                        if (globalVariables.ChasingStranger < 4) {
                            introductionC.setText(R.string.dream_nine_awake);
                            globalVariables.DreamsAction = 1;
                        } else {
                            introductionC.setText(R.string.dream_ten);
                            introductionOptions.setVisibility(VISIBLE);
                            introductionOptionOne.setText(R.string.dream_ten_option_one);
                            introductionOptionTwo.setText(R.string.dream_ten_option_two);
                            introductionOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                                    introductionOne.setVisibility(VISIBLE);
                                    switch (i) {
                                        case R.id.introduction_option_one:
                                            introductionOne.setText(R.string.dream_eleven_awake);
                                            if (globalVariables.DreamsAction == 3) {
                                                globalVariables.Doubt += -1;
                                            }
                                            if (globalVariables.DreamsAction != 2) {
                                                globalVariables.DreamsAction = 2;
                                                globalVariables.Conviction += 1;
                                            }
                                            break;
                                        case R.id.introduction_option_two:
                                            introductionOne.setText(R.string.dream_twelve_awake);
                                            if (globalVariables.DreamsAction == 2) {
                                                globalVariables.Conviction += -1;
                                            }
                                            if (globalVariables.DreamsAction != 3) {
                                                globalVariables.DreamsAction = 3;
                                                globalVariables.Doubt += 1;
                                            }
                                            break;
                                    }
                                }
                            });
                        }
                        if (globalVariables.Jordan == 1 || globalVariables.Jordan == 4) {
                            introductionTwo.setVisibility(VISIBLE);
                            introductionTwo.setText(R.string.dream_jordan);
                        }
                        break;
                    case 8:
                        if (globalVariables.Nigel == 0 || globalVariables.Nigel == 3) {
                            if (globalVariables.Ishimaru == 1 || globalVariables.Ishimaru == 4) {
                                introduction.setText(R.string.pallid_introduction_one_two);
                            } else {
                                introduction.setText(R.string.pallid_introduction_one_one);
                            }
                        } else {
                            if (globalVariables.Ishimaru == 1 || globalVariables.Ishimaru == 4) {
                                introduction.setText(R.string.pallid_introduction_two_two);
                            } else {
                                introduction.setText(R.string.pallid_introduction_two_one);
                            }
                        }
                        break;
                    case 9:
                        if (globalVariables.Ashleigh == 1 || globalVariables.Ashleigh == 4) {
                            introduction.setText(R.string.black_stars_introduction_ashleigh);
                        } else {
                            introduction.setText(R.string.black_stars_introduction);
                        }
                        break;
                    case 10:
                        if (globalVariables.Path == 1) {
                            introduction.setText(R.string.dim_introduction_below);
                        } else if (globalVariables.Path == 2) {
                            introduction.setText(R.string.dim_introduction_above);
                        }
                        break;
                }
                break;
            case 4:
                switch (globalVariables.CurrentScenario) {
                    case 1:
                        introduction.setText(R.string.untamed_introduction);
                        break;
                    case 6:
                        if (globalVariables.Ruins == 1) {
                            introduction.setText(R.string.eztli_introduction_one);
                        } else if (globalVariables.Ruins == 2) {
                            introduction.setText(R.string.eztli_introduction_two);
                        }
                        break;
                    case 8:
                        if (globalVariables.Custody == 1 || globalVariables.Relic == 2) {
                            introduction.setText(R.string.threads_introduction_one);
                        } else if (globalVariables.Custody == 2) {
                            introduction.setText(R.string.threads_introduction_two);
                        }
                        introductionOptions.setVisibility(VISIBLE);
                        introductionOptionOne.setText(R.string.threads_introduction_option_one);
                        introductionOptionTwo.setText(R.string.threads_introduction_option_two);
                        introductionOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                introductionOne.setVisibility(VISIBLE);
                                switch (checkedId) {
                                    case R.id.introduction_option_one:
                                        globalVariables.IchtacasTale = 1;
                                        introductionOne.setText(R.string.threads_introduction_three);
                                        progress = true;
                                        additionalOptions.setVisibility(GONE);
                                        introductionTwo.setVisibility(GONE);
                                        break;
                                    case R.id.introduction_option_two:
                                        globalVariables.IchtacasTale = 2;
                                        if (globalVariables.Custody == 2) {
                                            progress = false;
                                            introductionOne.setText(R.string.threads_introduction_five);
                                            additionalOptions.setVisibility(VISIBLE);
                                            additionalOptionOne.setText(R.string.threads_introduction_option_three);
                                            additionalOptionTwo.setText(R.string.threads_introduction_option_four);
                                            additionalOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                @Override
                                                public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                    if (checkedId == R.id.introduction_additional_option_one) {
                                                        globalVariables.IchtacasTale = 4;
                                                        introductionTwo.setVisibility(VISIBLE);
                                                        introductionTwo.setText(R.string.threads_introduction_six);
                                                        progress = true;
                                                    } else {
                                                        introductionTwo.setVisibility(GONE);
                                                        progress = true;
                                                    }
                                                }
                                            });
                                        } else {
                                            introductionOne.setText(R.string.threads_introduction_four);
                                            progress = true;
                                        }
                                        break;
                                }
                            }
                        });
                        break;
                    case 10:
                        StringBuilder boundaryIntroductionBuilder = new StringBuilder();
                        boundaryIntroductionBuilder.append(getString(R.string.boundary_introduction_one));
                        if (globalVariables.MissingIchtaca == 2) {
                            boundaryIntroductionBuilder.append(getString(R.string.boundary_introduction_two_a));
                        } else if (globalVariables.MissingIchtaca == 1) {
                            boundaryIntroductionBuilder.append(getString(R.string.boundary_introduction_two_b));
                        }
                        if (globalVariables.MissingRelic == 2) {
                            boundaryIntroductionBuilder.append(getString(R.string.boundary_introduction_three_a));
                        } else if (globalVariables.MissingRelic == 1) {
                            boundaryIntroductionBuilder.append(getString(R.string.boundary_introduction_three_b));
                        }
                        if (globalVariables.MissingAlejandro == 2) {
                            boundaryIntroductionBuilder.append(getString(R.string.boundary_introduction_four_a));
                        } else if (globalVariables.MissingAlejandro == 1) {
                            boundaryIntroductionBuilder.append(getString(R.string.boundary_introduction_four_b));
                        }
                        for (int i = 0; i < globalVariables.Investigators.size(); i++) {
                            if (globalVariables.GasolineUsed != 1) {
                                if (globalVariables.Investigators.get(i).Supplies % 29 == 0) {
                                    globalVariables.Investigators.get(i).Supplies = globalVariables.Investigators.get
                                            (i).Supplies / 29;
                                    globalVariables.GasolineUsed = 1;
                                } else if (globalVariables.Investigators.get(i).ResuppliesOne % 2 == 0) {
                                    globalVariables.Investigators.get(i).ResuppliesOne =
                                            globalVariables.Investigators.get
                                                    (i).ResuppliesOne / 2;
                                    globalVariables.GasolineUsed = 1;
                                } else {
                                    globalVariables.GasolineUsed = 2;
                                }
                            }
                        }
                        if (globalVariables.GasolineUsed == 2) {
                            boundaryIntroductionBuilder.append(getString(R.string.boundary_introduction_five));
                        }
                        boundaryIntroductionBuilder.append(getString(R.string.boundary_introduction_six));
                        String boundaryIntroduction = boundaryIntroductionBuilder.toString();
                        introduction.setText(boundaryIntroduction);
                        break;
                    case 18:
                        introduction.setText(R.string.heart_one_intro);
                        introductionOptions.setVisibility(VISIBLE);
                        if (globalVariables.IchtacasTale != 4 && globalVariables.MissingIchtaca == 2) {
                            introductionOptionOne.setVisibility(VISIBLE);
                            introductionOptionOne.setText(R.string.heart_one_intro_option_one);
                        } else {
                            introductionOptionOne.setVisibility(GONE);
                        }
                        if (globalVariables.IchtacasTale != 4 && (globalVariables.Alejandro == 2 ||
                                globalVariables.Custody == 1 || globalVariables.MissingAlejandro == 2)) {
                            introductionOptionTwo.setVisibility(VISIBLE);
                            introductionOptionTwo.setText(R.string.heart_one_intro_option_two);
                        } else {
                            introductionOptionTwo.setVisibility(GONE);
                        }
                        introductionOptionThree.setVisibility(VISIBLE);
                        introductionOptionThree.setText(R.string.heart_one_intro_option_three);
                        introductionOptionFour.setVisibility(VISIBLE);
                        introductionOptionFour.setText(R.string.heart_one_intro_option_four);
                        introductionOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                                progress = true;
                                globalVariables.JungleWatches = "1";
                                switch (i) {
                                    case R.id.introduction_option_one:
                                        introductionOne.setText(R.string.heart_one_intro_one);
                                        introductionOne.setVisibility(VISIBLE);
                                        break;
                                    case R.id.introduction_option_two:
                                        introductionOne.setText(R.string.heart_one_intro_two);
                                        introductionOne.setVisibility(VISIBLE);
                                        break;
                                    case R.id.introduction_option_three:
                                        introductionOne.setText(R.string.heart_one_intro_three);
                                        introductionOne.setVisibility(VISIBLE);
                                        break;
                                    case R.id.introduction_option_four:
                                        introductionOne.setVisibility(GONE);
                                        break;
                                }
                            }
                        });
                        break;
                    case 19:
                        introduction.setText(R.string.heart_two_intro);
                        break;
                        /*
                    case 20:
                        introduction.setText(R.string.city_intro);
                        introductionOptions.setVisibility(VISIBLE);
                        introductionOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                introductionOne.setVisibility(VISIBLE);
                                progress = true;
                                switch (i) {
                                    case R.id.introduction_option_one:
                                        introductionOne.setText(R.string.city_intro_one);
                                        globalVariables.Yithians = 1;
                                        break;
                                    case R.id.introduction_option_two:
                                        introductionOne.setText(R.string.city_intro_two);
                                        globalVariables.Yithians = 2;
                                        break;
                                }
                            }
                        });
                        break;*/
                    case 27:
                        break;
                    case 33:
                        break;
                    case 35:
                        break;
                }
        }

        if (globalVariables.CurrentScenario > 100) {
            switch (globalVariables.CurrentScenario) {
                case 101:
                    introduction.setText(R.string.rougarou_introduction);
                    break;
                case 102:
                    introduction.setText(R.string.carnevale_introduction);
                    break;
            }
        }

        Button backButton = findViewById(R.id.back_button);
        backButton.setTypeface(teutonic);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button continueButton = findViewById(R.id.continue_button);
        continueButton.setTypeface(teutonic);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (globalVariables.CurrentCampaign == 2 && globalVariables.CurrentScenario == 8 && globalVariables
                        .TownsfolkAction == 0) {
                    Toast toast = Toast.makeText(ScenarioIntroductionActivity.this, R.string.must_option, Toast
                            .LENGTH_SHORT);
                    toast.show();
                } else if (globalVariables.CurrentCampaign == 3 && globalVariables.CurrentScenario == 7 &&
                        globalVariables.DreamsAction == 0) {
                    Toast toast = Toast.makeText(ScenarioIntroductionActivity.this, R.string.must_option, Toast
                            .LENGTH_SHORT);
                    toast.show();
                } else if (globalVariables.CurrentCampaign == 4 && (globalVariables.CurrentScenario == 8 ||
                        globalVariables.CurrentScenario == 18 || globalVariables.CurrentScenario == 20) && !progress) {
                    Toast toast = Toast.makeText(ScenarioIntroductionActivity.this, R.string.must_option, Toast
                            .LENGTH_SHORT);
                    toast.show();
                } else {
                    Intent intent = new Intent(ScenarioIntroductionActivity.this, ScenarioSetupActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
