package com.shelevii.taxi;

import com.shelevii.taxi.io.KeyboardReader;
import com.shelevii.taxi.logistic.Manager;
import com.shelevii.taxi.logistic.Order;

public class CallCenter
{
    protected enum State {ASK_START_ADDRESS, ASK_DESTINATION_ADDRESS, ASK_OPTIONS, PROCESS_ORDER, ASK_ABOUT_CONTINUE, EXIT};

    private State state = State.ASK_START_ADDRESS;
    private Manager manager = new Manager();
    private KeyboardReader keyboardReader = new KeyboardReader();
    private Order orderToProcess;

    public static void main( String[] args )
    {
        new CallCenter().process();
    }

    public void process() {
        while (state != State.EXIT) {
            processOrder();
        }
        keyboardReader.cleanUp();
    }

    private void processOrder() {
        switch (state) {
            case ASK_START_ADDRESS:
                askStartAddress();
                break;
            case ASK_DESTINATION_ADDRESS:
                askDestinationAddress();
                break;
            case ASK_OPTIONS:
                askOptions();
                break;

            case PROCESS_ORDER:
                sendOrderToManager();
                break;

            case ASK_ABOUT_CONTINUE:
                askAboutContinue();
                break;
        }
    }

    private void askAboutContinue() {
        System.out.println("Do you want to make new order? Y/N");
        String value = keyboardReader.readLine().trim();
        if ("Y".equalsIgnoreCase(value)) {
            state = State.ASK_START_ADDRESS;
        } else if ("N".equalsIgnoreCase(value)) {
            state = State.EXIT;
        } else {
            System.out.println("Cannot recognize the answer. Please type Y or N");
        }
    }

    private void sendOrderToManager() {
        manager.processOrder(orderToProcess);
        state = State.ASK_ABOUT_CONTINUE;
    }

    private void askOptions() {
        System.out.println("Do you wanna order environment friendly electric car? Type Y if yes or N if you don't mind");
        String value = keyboardReader.readLine().trim();
        if ("Y".equalsIgnoreCase(value)) {
            orderToProcess.setEcoFriendly(true);
            state = State.PROCESS_ORDER;
        } else if ("N".equalsIgnoreCase(value)) {
            orderToProcess.setEcoFriendly(false);
            state = State.PROCESS_ORDER;
        } else {
            System.out.println("Cannot recognize the answer. Please type Y or N");
        }
    }

    private void askDestinationAddress() {
        System.out.println("Please provide the destination address:");
        orderToProcess.getRoute().setDestinationAddress(keyboardReader.readLine());
        state = State.ASK_OPTIONS;
    }

    private void askStartAddress() {
        orderToProcess = new Order();
        System.out.println("Please provide your address:");
        orderToProcess.getRoute().setStartAddress(keyboardReader.readLine());
        state = State.ASK_DESTINATION_ADDRESS;
    }
}
