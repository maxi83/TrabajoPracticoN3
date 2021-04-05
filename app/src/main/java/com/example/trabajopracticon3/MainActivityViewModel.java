package com.example.trabajopracticon3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel  extends ViewModel {
    private MutableLiveData<String> resulMutable;
    private MutableLiveData<Boolean> actEditexDolar;
    private MutableLiveData<Boolean> actEditexEuro;
    private MutableLiveData<Boolean> actRadioDolar;
    private MutableLiveData<Boolean> actRadioEuro;

    public LiveData<String> getResulMutable() {
        if (resulMutable==null){
            resulMutable = new MutableLiveData<>();
        }
        return resulMutable;
    }


    public LiveData<Boolean> getActivoActEditexDolar(){
        if (actEditexDolar==null){
            actEditexDolar = new MutableLiveData<>();
        }
        return actEditexDolar;
    }
    public LiveData<Boolean> getActivoActEditexEuro(){
        if (actEditexEuro==null){
            actEditexEuro = new MutableLiveData<>();
        }
        return actEditexEuro;
    }
    public LiveData<Boolean> getActivoActRadioDolar(){
        if (actRadioDolar==null){
            actRadioDolar = new MutableLiveData<>();
        }
        return actRadioDolar;
    }
    public LiveData<Boolean> getActivoActRadioEuro(){
        if (actRadioEuro==null){
            actRadioEuro = new MutableLiveData<>();
        }
        return actRadioEuro;
    }
    public void convertir(Boolean dolares, String dolarEt, String euroEt) {
        try {
            double result;
            if (dolares) {
                double dolar = Double.parseDouble(dolarEt);
                result = dolar * 0.85;
                resulMutable.setValue(result + " euros");
            } else {
                double euro = Double.parseDouble(euroEt);
                result = euro * 1.18;
                resulMutable.setValue(result + " dolares");
            }
        } catch (Exception ex) {
            resulMutable.setValue("Ingrese valor correcto por favaor");
        }
    }
}
