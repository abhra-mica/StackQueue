package stackandqueue;

import java.util.Stack;

public class QueueUsingTwoStacks {
	static Stack<String> stack1 = new Stack<>();
	static Stack<String> stack2 = new Stack<>();

	public static void main(String[] args) {
		enque("A");
		enque("B");
		enque("C");
		deque();
		enque("D");
		System.out.println("Queue size at this moment: " + size());
		deque();
		deque();
		deque();
		deque();
	}

	static void enque(String element) {
		stack1.push(element);
	}

	static void deque() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if (isQEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println(stack2.pop());
	}

	static int size() {
		return stack1.size() + stack2.size();
	}

	static boolean isQEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
}
