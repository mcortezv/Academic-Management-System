/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import com.sun.net.httpserver.Request;
import structures.Queue;

/**
 *
 * @author Sebas
 */
public class PersistenceRequests {
    private Queue<Request> requests;

    public PersistenceRequests(){
        this.requests = new Queue<Request>();
    }

    public void processNextRequest(){

    }
}