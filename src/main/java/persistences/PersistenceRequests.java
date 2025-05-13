/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;

import components.Request;
import structures.Queue;

/**
 *
 * @author Sebas
 */
public class PersistenceRequests {
    private Queue<Request> requests;

    public PersistenceRequests(){
        this.requests = new Queue<>();
    }

    public void processNextRequest(){

    }
}