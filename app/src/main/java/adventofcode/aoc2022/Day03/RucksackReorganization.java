package adventofcode.aoc2022.Day03;

import java.util.List;
import java.util.stream.IntStream;

import adventofcode.util.ReadInput;

/**
 * https://adventofcode.com/2022/day/3
 */
public class RucksackReorganization {

    public static void main(String[] args) {
        System.out.println("\n### Day 3: Rucksack Reorganisation ###\n");

        // file path as String
        final String filePath = "aoc2022/Day03/input";

        List<String> input = ReadInput.toListofStringsFrom(filePath);

        List<Compartments> compartments = RucksackParser.parseToCompartments(input);
        List<Rucksack> rucksacks = RucksackParser.parseToRucksacks(input);

        int part1 = findCommonItem(compartments);
        System.out.println("-> Part1: " + part1);
        
        int part2 = findBadge(rucksacks);
        System.out.println("-> Part2: " + part2);
    }

    // new solution

    private static int findCommonItem(List<Compartments> compartments) {
        return compartments.stream()
                .map(Compartments::findCommonItem)
                .mapToInt(Item::priorityValue)
                .sum();
    }

    private static int findBadge(List<Rucksack> rucksacks) {
        return IntStream.range(0, rucksacks.size()/3)
                .map(i -> i * 3)
                .mapToObj(i -> rucksacks.get(i).findBadge(rucksacks.get(i+1), rucksacks.get(i+2)))
                .mapToInt(Item::priorityValue)
                .sum();
    }

}