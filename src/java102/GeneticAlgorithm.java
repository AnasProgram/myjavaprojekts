package java102;
/*
Explanation of the concept
Genetic algorithms are a useful tool for machine learning. One simple way to find a solution to a problem that would typically be too difficult to brute force is through algorithms such as these.

For example, say our problem is, given the list [1,2,3,4,5,6,7,8,9,10], find a way to partition the list into two lists such that the sum of one list is 38 and the product of the other list is 210.
You could of course brute force it, using the fact that you can find the divisors of 210.
 But say you have the list of numbers from 1 to 50! That makes it a lot more difficult,
 and if we are not looking for a sum or product that is actually possible, just close to a given number,
  it's even harder to do by brute force.

Genetic algorithms are based on the idea that you can create a chromosome that represents a potential solution to your problem.
One way of representing such a chromosome is with a binary string of digits. In our example,
 we could represent one chromosome as 0010010111,
 and decide that 0 means that the corresponding number is in the "sum" pile and 1 means it is in the "product" pile,
 so this chromosome gives us 1+2+4+5+7=19 and 3*6*8*9*10=12960. Not very close.
 But the point is that you can easily represent any potential solution as a binary string!

Now, the key to a genetic algorithm is to generate many chromosomes, a large population,
if you will. The "genetic" part of the name comes from the fact that we will, in a sense,
let evolution bring our chromosomes as close as possible to our desired solution.
So what we do is generate a population of random chromosomes.
Then we calculate the fitness of those chromosomes in whatever way fits the problem.
In our case, we want to minimize the absolute difference of the sum from the ideal sum and likewise for the product,
so one way we can calculate a "score" of how good our estimate is is sqrt((chromosome sum - ideal sum)^2+(chromosome product - ideal product)^2).
We want to, of course, maximize fitness, so the closer our score is to 0 (that is, the closer the chromosome is to ideal), the bigger the fitness is. So what we can do is let our fitness be 1/(score + 1);
a fitness of 0 means it's nowhere near what we want,
and a fitness of 1 means we have exactly the right answer!

The evolution step involves taking a look at our population and selecting by fitness. This is done in a few steps:

Select two chromosomes from our original population. This is not done purely randomly.
This is done using what is called "roulette wheel selection",
where the chances of picking a chromosome are proportional to its fitness!
This means we are more likely to pick out chromosomes that are closer to our answer. Duplicate these chromosomes.
With a probability p_c, a crossover occurs between these two new chromosomes.
That means at some random bit along the length of the chromosome,
we cut off the rest of the chromosome and switch it with the cut off part of the other one.
In other words, say we have 01011010 and 11110110 and we crossover at the 3rd bit. This results in 010 10110 and 111 11010.
With a probability p_m, a mutation can occur at every bit along each new chromosome; the mutation rate is typically very small.
Add these two new chromosomes into our new population and repeat steps 1-3 until you have a new population the same size as the original one.
For obvious reasons, this is easier if you start off with an even sized original population.
Our goal here is to run the evolution process many times. Eventually, all the chromosomes in our population will have a fitness close to 1!
When we feel we have done enough runs, that is the time to cut it off, find the chromosome with the highest fitness,
and return that as the result.

Your task
We'll keep this task fairly simple. You will be given an outline of a GeneticAlgorithm class with a few methods.
The crossover and mutate methods are self-explanatory:
they take in two chromosomes or one and a probability (respectively) and return a crossed-over pair or a mutated chromosome.
The generate method generates a random chromosome of a given length (use this in your run method to create a population).
The select method will take a population and a corresponding list of fitnesses and return two chromosomes selected with the roulette wheel method.
The run method will take a fitness function that accepts a chromosome and returns the fitness of that chromosome,
the length of the chromosomes to generate (should be the same length as the goal chromosome),
the crossover and mutation probabilities, and an optional number of iterations (default to 100).
Make the population size whatever you want; 100 is a good number but anywhere between 50 and 1000 will work just fine (although the bigger,
the slower). After the iterations are finished, the method returns the chromosome it deemed to be fittest.
This fitness function will be preloaded (Helper.Fitness in C#)!
What the test will do is generate a random binary string of 35 digits (a random Integer with 35 bits for Ruby),
and your algorithm must discover that string! The fitness will be calculated in a way similar to above,
where the score of a chromosome is the number of bits that differ from the goal string.

The crossover probability we will use is 0.6 and the mutation probability we will use is 0.002. Now,
since the chromosome length is small, 100 iterations should be enough to get the correct answer every time.
The test fixture will run the algorithm 10 times on 10 different goal strings. If not all of them work,
then you can try again and you'll probably be fine.

Good luck and have fun!
 */
import java.util.function.ToDoubleFunction;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.lang.StringBuilder;
import java.util.Collections;

public class GeneticAlgorithm {

    private final static int DEFAULT_ITERATIONS = 100;
    private final static int POPULATION_SIZE = 100;

    private String generate(int length) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < length; i++){
            sb.append(new Random().nextBoolean() ? "0" : "1");
        }

        return sb.toString();
    }

    private String[] select(List<String> population, List<Double> fitnesses) {

        double sum = 0.0;

        for(double i : fitnesses) sum += i;

        String[] result = new String[2];

        for(int i = 0; i < 2; i++){

            double random = new Random().nextDouble()*sum;

            double tempSum = 0.0;

            int j = -1;

            while(tempSum < random){
                j++;
                tempSum += fitnesses.get(j);
            }

            result[i] = population.get(j);
        }

        return result;
    }

    private String mutate(String chromosome, double p) {
        char[] chars = chromosome.toCharArray();

        for(int i = 0; i < chromosome.length(); i++){
            double random = new Random().nextDouble();

            if(random < p){
                chars[i] = (chars[i] == '1' ) ? '0' : '1';
            }
        }

        return new String(chars);
    }

    private String[] crossover(String chromosome1, String chromosome2) {

        int random = new Random().nextInt(chromosome1.length()-1)+1;

        String newChromosome1 = chromosome1.substring(0, random)+chromosome2.substring(random, chromosome2.length());
        String newChromosome2 = chromosome2.substring(0, random)+chromosome1.substring(random, chromosome1.length());

        return new String[]{newChromosome1,newChromosome2};
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m) {
        // TODO: Implement the run method
        return run(fitness, length, p_c, p_m, DEFAULT_ITERATIONS);
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m, int iterations) {

        List<String> population = new ArrayList<>();

        for(int i = 0; i < POPULATION_SIZE; i++){
            population.add(generate(length));
        }

        for(int i = 0; i < iterations; i++){

            List<Double> fitnesses = new ArrayList<>();

            for(String chromosome : population){
                fitnesses.add(fitness.applyAsDouble(chromosome));
            }

            List<String> newPopulation = new ArrayList<>();

            for(int j = 0; j < POPULATION_SIZE; j+=2){
                String[] newbies = select(population, fitnesses);
                if(new Random().nextDouble() < p_c){
                    newbies = crossover(newbies[0], newbies[1]);
                }
                newPopulation.add(mutate(newbies[0], p_m));
                newPopulation.add(mutate(newbies[1], p_m));
            }

            population = newPopulation;

        }

        List<Double> fitnesses = new ArrayList<>();

        for(String chromosome : population){
            fitnesses.add(fitness.applyAsDouble(chromosome));
        }

        int index = fitnesses.indexOf(Collections.max(fitnesses));

        return population.get(index);

    }
}
