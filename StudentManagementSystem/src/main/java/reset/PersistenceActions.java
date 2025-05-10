/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reset;
import components.Action;
import structures.Stack;

/**
 *
 * @author Sebas
 */
public class PersistenceActions {
    private Stack<Action> actions;

    public PersistenceActions(){
        actions = new Stack<Action>();
    }
}