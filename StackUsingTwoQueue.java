package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue {
	static Queue<String> queue1 = new LinkedList<>();
	static Queue<String> queue2 = new LinkedList<>();
	static boolean queue1Selected = true;

	public static void main(String[] args) {
		push("A");
		push("B");
		push("C");
		System.out.println("Stack Size: " + size());
		pop();
		push("D");
		pop();
		pop();
		pop();
		System.out.println("Is Stack Empty: " + isStackEmpty());
		pop();

	}

	public static void push(String element) {
		if (queue1Selected)
			queue1.add(element);
		else
			queue2.add(element);
	}

	public static void pop() {
		if (queue2.isEmpty()) {
			while (queue1.size() > 1) {
				queue2.add(queue1.poll());
			}
			System.out.println("Retrieve element from q-1 : " + queue1.poll());
			queue1Selected = false;
		} else {
			while (queue2.size() > 1) {
				queue1.add(queue2.poll());
			}
			System.out.println("Retrive element from q-2 : " + queue2.poll());
			queue1Selected = true;
		}
	}

	public static int size() {
		return queue1.size() + queue2.size();
	}

	public static boolean isStackEmpty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}
}
