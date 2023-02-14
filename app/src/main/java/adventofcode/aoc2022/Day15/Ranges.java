package adventofcode.aoc2022.Day15;

import java.util.Iterator;
import java.util.List;

/**
 * Ranges
 */
public record Ranges(List<Range> ranges) {

    // Add a new range to this List of Ranges. Check for each element (Range)
    // in this List if it can be merged woth the new Range. If yes merge them
    // and remove the old Range.
    public void add(Range range) {
        // System.out.println("\nRanges.add()");
        for (Iterator<Range> iterator = this.ranges.iterator(); iterator.hasNext();) {
            Range element = iterator.next();

            if (element.contains(range) || range.contains(element) || element.overlap(range)) {
                // System.out.println(" > merge element: " + element + " with range: " + range);
                range = element.merge(range);
                iterator.remove();
            }
        }

        this.ranges.add(range);
    }

}
