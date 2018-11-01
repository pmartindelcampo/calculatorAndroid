package com.example.pablom.micalculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Double memoria = 0.0;
    NumberFormat numberFormat;

    @Override
    protected void onCreate(Bundle estadoAlmacenado) {
        super.onCreate(estadoAlmacenado);
        setContentView(R.layout.activity_main);

        // Formato que se va a dar a los resultados
        numberFormat = DecimalFormat.getNumberInstance(Locale.UK);
        numberFormat.setMaximumFractionDigits(6);
        numberFormat.setGroupingUsed(false);

        final TextView tvResult = findViewById(R.id.tvResult);

        final String[] operators = getResources().getStringArray(R.array.operators);

        // Recupera los datos al cambiar de actividad
        if (estadoAlmacenado != null) {
            tvResult.setText(estadoAlmacenado.getString("TVRESULT"));
            memoria = estadoAlmacenado.getDouble("MEMORIA");
        }

        Button boton0 = findViewById(R.id.button0);
        boton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printZero(tvResult);
            }
        });

        Button boton1 = findViewById(R.id.button1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumbers(tvResult, getString(R.string.number_1));
            }
        });

        Button boton2 = findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumbers(tvResult, getString(R.string.number_2));
            }
        });

        Button boton3 = findViewById(R.id.button3);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumbers(tvResult, getString(R.string.number_3));
            }
        });

        Button boton4 = findViewById(R.id.button4);
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumbers(tvResult, getString(R.string.number_4));
            }
        });

        Button boton5 = findViewById(R.id.button5);
        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumbers(tvResult, getString(R.string.number_5));
            }
        });

        Button boton6 = findViewById(R.id.button6);
        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumbers(tvResult, getString(R.string.number_6));
            }
        });

        Button boton7 = findViewById(R.id.button7);
        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumbers(tvResult, getString(R.string.number_7));
            }
        });

        Button boton8 = findViewById(R.id.button8);
        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumbers(tvResult, getString(R.string.number_8));
            }
        });

        Button boton9 = findViewById(R.id.button9);
        boton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumbers(tvResult, getString(R.string.number_9));
            }
        });

        Button botonComma = findViewById(R.id.buttonComma);
        botonComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printComma(tvResult, operators);
            }
        });

        Button botonC = findViewById(R.id.buttonC);
        botonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteResult(tvResult);
            }
        });

        Button botonCE = findViewById(R.id.buttonCE);
        if (botonCE != null) {
            botonCE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteResult(tvResult);
                }
            });
        }

        Button botonDEL = findViewById(R.id.buttonDel);
        if (botonDEL != null) {
            botonDEL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteLastChar(tvResult);
                }
            });
        }

        Button botonMPlus = findViewById(R.id.buttonMPlus);
        botonMPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToMemory(tvResult, operators);
            }
        });

        Button botonMMinus = findViewById(R.id.buttonMMinus);
        if (botonMMinus != null) {
            botonMMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    substractFromMemory(tvResult, operators);
                }
            });
        }

        Button botonM = findViewById(R.id.buttonM);
        if (botonM != null) {
            botonM.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recoverAndClearMemory(tvResult, operators);
                }
            });
        }

        Button botonMC = findViewById(R.id.buttonMC);
        if (botonMC != null) {
            botonMC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearMemory();
                }
            });
        }

        Button botonMR = findViewById(R.id.buttonMR);
        if (botonMR != null) {
            botonMR.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recoverMemory(tvResult, operators);
                }
            });
        }

        Button botonPot = findViewById(R.id.buttonPot);
        botonPot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opPot(tvResult, operators);
            }
        });

        Button botonRaiz = findViewById(R.id.buttonRaiz);
        botonRaiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opRaiz(tvResult, operators);
            }
        });

        Button botonPorc = findViewById(R.id.buttonPorc);
        botonPorc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opPorc(tvResult ,operators);
            }
        });

        Button botonPlusMinus = findViewById(R.id.buttonPlusMinus);
        botonPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opPlusMinus(tvResult, operators) ;
            }
        });

        Button botonSin = findViewById(R.id.buttonSin);
        if (botonSin != null) {
            botonSin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opSin(tvResult, operators);
                }
            });
        }

        Button botonCos = findViewById(R.id.buttonCos);
        if (botonCos != null) {
            botonCos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opCos(tvResult, operators);
                }
            });
        }

        Button botonTan = findViewById(R.id.buttonTan);
        if (botonTan != null) {
            botonTan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opTan(tvResult, operators);
                }
            });
        }

        Button botonPlus = findViewById(R.id.buttonPlus);
        botonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printOperators(tvResult, getString(R.string.op_plus), operators);
            }
        });

        Button botonMinus = findViewById(R.id.buttonMinus);
        botonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printOperators(tvResult, getString(R.string.op_minus), operators);
            }
        });

        Button botonMult = findViewById(R.id.buttonMult);
        botonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printOperators(tvResult,getString(R.string.op_mult), operators);
            }
        });

        Button botonDiv = findViewById(R.id.buttonDiv);
        botonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printOperators(tvResult, getString(R.string.op_div), operators);
            }
        });

        Button botonEquals = findViewById(R.id.buttonEquals);
        botonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(tvResult, operators);
            }
        });

        Button boton1ByX = findViewById(R.id.button1ByX);
        if (boton1ByX != null) {
            boton1ByX.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    op1ByX(tvResult, operators);
                }
            });
        }

        Button botonOff = findViewById(R.id.buttonOff);
        if(botonOff != null) {
            botonOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        Button botonPi = findViewById(R.id.buttonPi);
        if (botonPi != null) {
            botonPi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    printPi(tvResult, operators);
                }
            });
        }
    }

    public void onSaveInstanceState(Bundle estado) {
        super.onSaveInstanceState(estado);
        TextView tvResult = findViewById(R.id.tvResult);
        // Guarda los datos antes de cambiar de actividad
        estado.putString("TVRESULT", tvResult.getText().toString());
        estado.putDouble("MEMORIA", memoria);
    }

    private boolean stringContainsItemsFromArray(String string, String[] array) {
        for (String s : array) {
            if (string.contains(s)) {
                return true;
            }
        }
        return false;
    }

    private void printNumbers(TextView tvResult, String num) {
        String text = tvResult.getText().toString();
        // Si el texto del resultado es 0.0 ó 0
        if (text.equals(getString(R.string.result_ini)) || text.equals(getString(R.string.number_0))) {
            tvResult.setText(num);
        } else {
            String newResult = text + num;
            tvResult.setText(newResult);
        }
    }

    private void printZero(TextView tvResult) {
        if (!tvResult.getText().toString().equals(getString(R.string.result_ini))) {
            String newResult = tvResult.getText().toString() + getString(R.string.number_0);
            tvResult.setText(newResult);
        }
    }

    private void printComma(TextView tvResult, String[] operators) {
        String text = tvResult.getText().toString();
        String lastChar = String.valueOf(text.charAt(text.length() - 1));
        // Si el texto del resultado no tiene otra coma o si se está escribiendo la primera coma del segundo operando
        if (!text.contains(getString(R.string.comma)) || stringContainsItemsFromArray(text, operators) && !text.substring(getIndexOfOperator(text)).contains(getString((R.string.comma))) && !stringContainsItemsFromArray(lastChar, operators)) {
            String newResult = text + getString(R.string.comma);
            tvResult.setText(newResult);
        }
    }

    private void printPi(TextView tvResult, String[] operators) {
        String result = tvResult.getText().toString();
        // Si el texto del resultado no contiene un operador
        if(!stringContainsItemsFromArray(result, operators)) {
            tvResult.setText(String.valueOf(numberFormat.format(Math.PI)));
        } else {
            String s = result.substring(0, getIndexOfOperator(result) + 1);
            String newResult = s + String.valueOf(numberFormat.format(Math.PI));
            tvResult.setText(newResult);
        }
    }

    private void deleteResult(TextView tvResult) {
        tvResult.setText(R.string.result_ini);
    }

    private void deleteLastChar(TextView tvResult) {
        StringBuilder sb = new StringBuilder(tvResult.getText().toString());
        sb.deleteCharAt(sb.length()-1);
        if (sb.length() != 0) {
            tvResult.setText(sb.toString());
        } else {
            tvResult.setText(getString(R.string.result_ini));
        }
    }

    private void addToMemory(TextView tvResult, String[] operators) {
        String result = tvResult.getText().toString();
        String lastChar = String.valueOf(result.charAt(result.length() - 1));
        // Si el texto del resultado no tiene un operador se añade el número a la memoria, si no se hace la operación primero
        if (!stringContainsItemsFromArray(result, operators) || String.valueOf(result.charAt(0)).equals(getString(R.string.op_minus)) && !stringContainsItemsFromArray(result.substring(1), operators)) {
            memoria = memoria + Double.parseDouble(result);
            // Si el último carácter es un operador se muestra un mensaje de error
        } else if (stringContainsItemsFromArray(lastChar, operators)) {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_fail), Toast.LENGTH_SHORT);
            toast.show();
        } else {
            calculate(tvResult, operators);
            memoria = memoria + Double.parseDouble(tvResult.getText().toString());
        }
    }

    private void substractFromMemory(TextView tvResult, String[] operators) {
        String result = tvResult.getText().toString();
        String lastChar = String.valueOf(result.charAt(result.length() - 1));
        // Si el texto del resultado no tiene un operador se resta el número a la memoria, si no se hace la operación primero
        if (!stringContainsItemsFromArray(result, operators) || String.valueOf(result.charAt(0)).equals(getString(R.string.op_minus)) && !stringContainsItemsFromArray(result.substring(1), operators)) {
            memoria = memoria - Double.parseDouble(result);
            // Si el último carácter es un operador se muestra un mensaje de error
        } else if (stringContainsItemsFromArray(lastChar, operators)) {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_fail), Toast.LENGTH_SHORT);
            toast.show();
        } else {
            calculate(tvResult, operators);
            memoria = memoria - Double.parseDouble(tvResult.getText().toString());
        }
    }

    private void recoverMemory(TextView tvResult, String[] operators) {
        if (!memoria.equals(0.0)) {
            String result = tvResult.getText().toString();
            // Si no hay un operador en el texto reemplaza la memoria en el primer operando, sino en el segundo
            if (!stringContainsItemsFromArray(result, operators) || String.valueOf(result.charAt(0)).equals(getString(R.string.op_minus)) && !stringContainsItemsFromArray(result.substring(1), operators)) {
                tvResult.setText(String.valueOf(numberFormat.format(memoria)));
            } else {
                String s = result.substring(0, getIndexOfOperator(result) + 1);
                String newResult = s + String.valueOf(numberFormat.format(memoria));
                tvResult.setText(newResult);
            }
        }
    }

    private void clearMemory() {
        memoria = 0.0;
    }

    private void recoverAndClearMemory(TextView tvResult, String[] operators) {
        if (!memoria.equals(0.0)) {
            String result = tvResult.getText().toString();
            if (!stringContainsItemsFromArray(result, operators) || String.valueOf(result.charAt(0)).equals(getString(R.string.op_minus)) && !stringContainsItemsFromArray(result.substring(1), operators)) {
                tvResult.setText(String.valueOf(numberFormat.format(memoria)));
                memoria = 0.0;
            } else {
                String s = result.substring(0, getIndexOfOperator(result) + 1);
                String newResult = s + String.valueOf(numberFormat.format(memoria));
                tvResult.setText(newResult);
                memoria = 0.0;
            }
        }
    }

    private void opPot(TextView tvResult, String[] operators) {
        String result = tvResult.getText().toString();
        String lastChar = String.valueOf(result.charAt(result.length() - 1));
        // Si solo hay un número en el resultado realiza la operación con ese número, sino la realiza sobre el resultado de la operación escrita
        if (!stringContainsItemsFromArray(result, operators) || String.valueOf(result.charAt(0)).equals(getString(R.string.op_minus)) && !stringContainsItemsFromArray(result.substring(1), operators)) {
            Double num = Double.parseDouble(result);
            tvResult.setText(String.valueOf(numberFormat.format(Math.pow(num, 2))));
            // Si el último carácter es un operador se muestra un mensaje de error
        } else if (stringContainsItemsFromArray(lastChar, operators)) {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_fail), Toast.LENGTH_SHORT);
            toast.show();
        } else {
            calculate(tvResult, operators);
            Double num = Double.parseDouble(tvResult.getText().toString());
            tvResult.setText(String.valueOf(numberFormat.format(Math.pow(num, 2))));
        }
    }

    private void opRaiz(TextView tvResult, String[] operators) {
        String result = tvResult.getText().toString();
        String lastChar = String.valueOf(result.charAt(result.length() - 1));
        // Si solo hay un número en el resultado realiza la operación con ese número, sino la realiza sobre el resultado de la operación escrita
        if (!stringContainsItemsFromArray(result, operators) || String.valueOf(result.charAt(0)).equals(getString(R.string.op_minus)) && !stringContainsItemsFromArray(result.substring(1), operators)) {
            Double num = Double.parseDouble(result);
            if (num < 0) {
                // Si se intenta hacer una raíz de un número negativo se muestra un mensaje de error
                Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_negsqrt) , Toast.LENGTH_SHORT);
                toast.show();
                tvResult.setText(getString(R.string.result_ini));
            } else {
                tvResult.setText(String.valueOf(numberFormat.format(Math.sqrt(num))));
            }
            // Si el último carácter es un operador se muestra un mensaje de error
        } else if (stringContainsItemsFromArray(lastChar, operators)) {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_fail), Toast.LENGTH_SHORT);
            toast.show();
        } else {
            calculate(tvResult, operators);
            Double num = Double.parseDouble(tvResult.getText().toString());
            if (num < 0) {
                // Si se intenta hacer una raíz de un número negativo se muestra un mensaje de error
                Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_negsqrt) , Toast.LENGTH_SHORT);
                toast.show();
                tvResult.setText(getString(R.string.result_ini));
            } else {
                tvResult.setText(String.valueOf(numberFormat.format(Math.sqrt(num))));
            }
        }
    }

    private void opPorc(TextView tvResult, String[] operators) {
        String result = tvResult.getText().toString();
        String lastChar = String.valueOf(result.charAt(result.length() - 1));
        // Si solo hay un número en el resultado realiza la operación con ese número, sino la realiza sobre el resultado de la operación escrita
        if (!stringContainsItemsFromArray(result, operators) || String.valueOf(result.charAt(0)).equals(getString(R.string.op_minus)) && !stringContainsItemsFromArray(result.substring(1), operators)) {
            Double num = Double.parseDouble(result);
            tvResult.setText(String.valueOf(numberFormat.format(num/100)));
            // Si el último carácter es un operador se muestra un mensaje de error
        } else if (stringContainsItemsFromArray(lastChar, operators)) {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_fail), Toast.LENGTH_SHORT);
            toast.show();
        } else {
            calculate(tvResult, operators);
            Double num = Double.parseDouble(tvResult.getText().toString());
            tvResult.setText(String.valueOf(numberFormat.format(num/100)));
        }
    }

    private void opPlusMinus(TextView tvResult, String[] operators) {
        String resultString = tvResult.getText().toString();
        String lastChar = String.valueOf(resultString.charAt(resultString.length() - 1));
        // Si solo hay un número en el resultado realiza la operación con ese número, sino la realiza sobre el resultado de la operación escrita
        if ((!stringContainsItemsFromArray(resultString, operators) || resultString.indexOf(getString(R.string.op_minus)) == 0) && !resultString.equals(getString(R.string.result_ini)) && !stringContainsItemsFromArray(resultString.substring(1), operators)) {
            Double num = Double.parseDouble(resultString);
            tvResult.setText(String.valueOf(numberFormat.format(num*-1)));
            // Si el último carácter es un operador se muestra un mensaje de error
        } else if (stringContainsItemsFromArray(lastChar, operators)) {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_fail), Toast.LENGTH_SHORT);
            toast.show();
        } else {
            calculate(tvResult, operators);
            Double num = Double.parseDouble(tvResult.getText().toString());
            tvResult.setText(String.valueOf(numberFormat.format(num*-1)));
        }
    }

    private void opSin(TextView tvResult, String[] operators) {
        String result = tvResult.getText().toString();
        String lastChar = String.valueOf(result.charAt(result.length() - 1));
        // Si solo hay un número en el resultado realiza la operación con ese número, sino la realiza sobre el resultado de la operación escrita
        if (!stringContainsItemsFromArray(result, operators) || String.valueOf(result.charAt(0)).equals(getString(R.string.op_minus)) && !stringContainsItemsFromArray(result.substring(1), operators)) {
            Double num = Double.parseDouble(result);
            tvResult.setText(String.valueOf(numberFormat.format(Math.sin(num))));
            // Si el último carácter es un operador se muestra un mensaje de error
        } else if(stringContainsItemsFromArray(lastChar, operators)) {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_fail), Toast.LENGTH_SHORT);
            toast.show();
        } else {
            calculate(tvResult, operators);
            Double num = Double.parseDouble(tvResult.getText().toString());
            tvResult.setText(String.valueOf(numberFormat.format(Math.sin(num))));
        }
    }

    private void opCos(TextView tvResult, String[] operators) {
        String result = tvResult.getText().toString();
        String lastChar = String.valueOf(result.charAt(result.length() - 1));
        // Si solo hay un número en el resultado realiza la operación con ese número, sino la realiza sobre el resultado de la operación escrita
        if (!stringContainsItemsFromArray(result, operators) || String.valueOf(result.charAt(0)).equals(getString(R.string.op_minus)) && !stringContainsItemsFromArray(result.substring(1), operators)) {
            Double num = Double.parseDouble(result);
            tvResult.setText(String.valueOf(numberFormat.format(Math.cos(num))));
            // Si el último carácter es un operador se muestra un mensaje de error
        } else if(stringContainsItemsFromArray(lastChar, operators)) {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_fail), Toast.LENGTH_SHORT);
            toast.show();
        } else {
            calculate(tvResult, operators);
            Double num = Double.parseDouble(tvResult.getText().toString());
            tvResult.setText(String.valueOf(numberFormat.format(Math.cos(num))));
        }
    }

    private void opTan(TextView tvResult, String[] operators) {
        String result = tvResult.getText().toString();
        String lastChar = String.valueOf(result.charAt(result.length() - 1));
        // Si solo hay un número en el resultado realiza la operación con ese número, sino la realiza sobre el resultado de la operación escrita
        if (!stringContainsItemsFromArray(result, operators) || String.valueOf(result.charAt(0)).equals(getString(R.string.op_minus)) && !stringContainsItemsFromArray(result.substring(1), operators)) {
            Double num = Double.parseDouble(result);
            tvResult.setText(String.valueOf(numberFormat.format(Math.tan(num))));
            // Si el último carácter es un operador se muestra un mensaje de error
        } else if (stringContainsItemsFromArray(lastChar, operators)) {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_fail), Toast.LENGTH_SHORT);
            toast.show();
        } else {
            calculate(tvResult, operators);
            Double num = Double.parseDouble(tvResult.getText().toString());
            tvResult.setText(String.valueOf(numberFormat.format(Math.tan(num))));
        }
    }

    private void printOperators(TextView tvResult, String operator, String[] operators) {
        String result = tvResult.getText().toString();
        String lastChar = String.valueOf(result.charAt(result.length() - 1));
        // Si no hay un operador ya se escribe el operador, sino se realiza la operación y se escribe el operador a continuación
        if (!stringContainsItemsFromArray(result, operators)) {
            String newResult = result + operator;
            tvResult.setText(newResult);
        } else if (String.valueOf(result.charAt(0)).equals(getString(R.string.op_minus)) && !stringContainsItemsFromArray(result.substring(1), operators)) {
            String newResult = result + operator;
            tvResult.setText(newResult);
            //Si el último carácter es un operador se sustituye por el nuevo operador
        } else if (String.valueOf(result.charAt(0)).equals(getString(R.string.op_minus)) && stringContainsItemsFromArray(lastChar, operators)) {
            StringBuilder newResult = new StringBuilder(result);
            newResult.deleteCharAt(newResult.length() - 1);
            newResult.append(operator);
            tvResult.setText(newResult.toString());
        } else if (!stringContainsItemsFromArray(lastChar, operators)) {
            calculate(tvResult, operators);
            String newResult = tvResult.getText().toString() + operator;
            tvResult.setText(newResult);
        } else {
            StringBuilder newResult = new StringBuilder(result);
            newResult.deleteCharAt(newResult.length() - 1);
            newResult.append(operator);
            tvResult.setText(newResult.toString());
        }
    }

    private void op1ByX(TextView tvResult, String[] operators) {
        String result = tvResult.getText().toString();
        String lastChar = String.valueOf(result.charAt(result.length() - 1));
        // Si solo hay un número en el resultado realiza la operación con ese número, sino la realiza sobre el resultado de la operación escrita
        if (!stringContainsItemsFromArray(result, operators) || String.valueOf(result.charAt(0)).equals(getString(R.string.op_minus))) {
            Double num = Double.parseDouble(result);
            if (num != 0) {
                tvResult.setText(String.valueOf(numberFormat.format(1 / num)));
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_divby0), Toast.LENGTH_SHORT);
                toast.show();
            }
            // Si el último carácter es un operador se muestra un mensaje de error
        } else if (stringContainsItemsFromArray(lastChar, operators)) {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_fail), Toast.LENGTH_SHORT);
            toast.show();
        } else {
            calculate(tvResult, operators);
            Double num = Double.parseDouble(tvResult.getText().toString());
            if (num != 0) {
                tvResult.setText(String.valueOf(numberFormat.format(1 / num)));
            } else {
                tvResult.setText(getString(R.string.result_ini));
                Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_divby0), Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    private void calculate(TextView tvResult, String[] operators) {
        String text = tvResult.getText().toString();
        String lastChar = String.valueOf(text.charAt(text.length() - 1));
        if (stringContainsItemsFromArray(text.substring(1), operators) && !stringContainsItemsFromArray(lastChar, operators)) {
            int indexOfOperator = getIndexOfOperator(text);
            Double num1 = Double.valueOf(text.substring(0, indexOfOperator));
            Double num2 = Double.valueOf(text.substring(indexOfOperator + 1));
            String operator = String.valueOf(text.charAt(indexOfOperator));
            Double result = calculateOperation(num1, operator, num2);
            System.out.println(String.valueOf(numberFormat.format(result)));
            tvResult.setText(String.valueOf(numberFormat.format(result)));
        } else if (stringContainsItemsFromArray(lastChar, operators) || !stringContainsItemsFromArray(text.substring(1), operators)){
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_operate) , Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private Double calculateOperation(Double num1, String operator, Double num2) {
        Double result;
        if (operator.equals(getString(R.string.op_plus))) {
            result = num1 + num2;
        } else if (operator.equals(getString(R.string.op_minus))) {
            result = num1 - num2;
        } else if (operator.equals(getString(R.string.op_mult))) {
            result = num1 * num2;
        } else {
            if(num2 == 0) {
                // Si se intenta dividir entre 0 se muestra un mensaje de error
                result = 0.0;
                Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.msg_divby0), Toast.LENGTH_SHORT);
                toast.show();
            } else {
                result = num1 / num2;
            }
        }
        return result;
    }

    private int getIndexOfOperator(String text) {
        int index;
        if (text.contains(getString(R.string.op_plus))) {
            index = text.indexOf(getString(R.string.op_plus));
        } else if (text.contains(getString(R.string.op_mult))){
            index = text.indexOf(getString(R.string.op_mult));
        } else if (text.contains(getString(R.string.op_div))) {
            index = text.indexOf(getString(R.string.op_div));
        } else {
            index = text.lastIndexOf(getString(R.string.op_minus));
        }
        return index;
    }
}
