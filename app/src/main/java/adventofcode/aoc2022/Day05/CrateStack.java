package adventofcode.aoc2022.Day05;

import java.util.Deque;

public record CrateStack(Deque<Crate> stack) {

    public Crate peek() {
        return this.stack.peek();
    }

    public Crate pop() {
        return this.stack.pop();
    }

    public boolean offerFirst(Crate e) {
        return this.stack.offerFirst(e);
    }

    public boolean offerLast(Crate e) {
        return this.stack.offerLast(e);
    }
}
