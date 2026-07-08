package com.zaalima.engine;

public class CircuitBreaker
    {

    private boolean open;

    public void openCircuit() 
    {
        open = true;
    }

    public void closeCircuit()
        {
        open = false;
    }

    public boolean isOpen() {
        return open;
    }
}
