/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa_assignment_01;

/**
 *
 * @author 1999k
 */
class UserDetailsNode {

    int id;
    String name;
    int age;
    int contactNumber;
    String email;

    UserDetailsNode nextNode;

    public UserDetailsNode(int id, String name, int age, int contactNumber, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.email = email;
    }

}

public class LinkedList {

    UserDetailsNode headNode;
    UserDetailsNode tailNode;

    int nodeCount = 0;

    public void addNodeAtLast(int id, String name, int age, int contactNumber, String email) {

        UserDetailsNode newNode = new UserDetailsNode(id, name, age, contactNumber, email);

        if (headNode == null) {
            headNode = newNode;
            tailNode = newNode;
        } else {
            tailNode.nextNode = newNode;
            tailNode = newNode;
        }

        nodeCount++;

    }

    public UserDetailsNode getNodeAt(int idPosition) {

        UserDetailsNode currentNode = headNode;

        for (int i = 1; i < idPosition; i++) {
            currentNode = currentNode.nextNode;
        }

        return currentNode;

    }

    public void removeNodeAt(int idPosition) {

        if (headNode.nextNode == null) {

            headNode = null;
            tailNode = null;

        } else {

            UserDetailsNode selectedNode = getNodeAt(idPosition);

            selectedNode.id = selectedNode.nextNode.id;
            selectedNode.name = selectedNode.nextNode.name;
            selectedNode.age = selectedNode.nextNode.age;
            selectedNode.contactNumber = selectedNode.nextNode.contactNumber;
            selectedNode.email = selectedNode.nextNode.email;

            selectedNode.nextNode = selectedNode.nextNode.nextNode;

        }

        nodeCount--;

    }

    public UserDetailsNode[] getAllNodes() {

        UserDetailsNode nodeArray[] = new UserDetailsNode[nodeCount];

        UserDetailsNode currentNode = headNode;

        for (int i = 0; i < nodeCount; i++) {

            nodeArray[i] = currentNode;
            currentNode = currentNode.nextNode;

        }

        return nodeArray;

    }

    public int getSize() {
        return nodeCount;
    }

    public boolean isEmpty() {
        if (headNode == null) {
            return true;
        } else {
            return false;
        }
    }

}
