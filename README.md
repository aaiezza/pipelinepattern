# Pipeline Pattern

Pipeline Pattern is a helpful framework for dividing a problem into smaller, reusable code components. This is a simple yet powerful structural pattern to organize a complex logic into smaller reusable components, which can be added/removed/modified independently.
- - -
Original concepts by [Benoy Antony](mailto://bantony@gmail.com).
- - -

###  Forces for the Pattern
- The logic is complex.
- The simplicity and readability of the code is critical.
- The logic can be divided into multiple modules.
- The modules are potentially reusable for different use-cases.

### Description of the Pattern
#### Stage
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A **Stage** represents a module or work unit. The stage can be reused in different pipelines. Stages collaborate with each other by sharing data in the **Context**.

#### Pipeline
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A **Pipeline** holds a collection of stages and executes them. A **Pipeline** can contains _normal_ stages, _error_ stages and _final_ stages. **Normal stages** are executed. In case of any error, the execution of normal stages is stopped and **error stages** are executed. After this, **final stages** are executed. The error and final stages are optional.

#### Context
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A **Context** acts as the holder class to share data between client and pipeline and also among stages.

#### Client
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A **Client** setups the Pipeline by adding stages during init time and then executes pipeline by setting up the context.
- - -
Sample Code illustrating usage of Pipeline Pattern
```
/**
 * A sample client class to demonstrate the usage of Pipeline Pattern
 * 
 * Takes an array of integers as input and does the following 
 * calculate the sum of all numbers
 * Increase each value in the array by adding the sum
 * sort the numbers
 * the sorted list is returned
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */
public class NumberMagicWithSum
{
    private static final Pipeline S_PIPELINE = new SequentialPipeline();

    static
    {
        S_PIPELINE.addStage( new GetSumStage() );
        S_PIPELINE.addStage( new IncreaseValueStage() );
        S_PIPELINE.addStage( new SortStage() );
        }

        public int[] doMagic( int[] number )
        {
            NumberMagicContext nmContext = new NumberMagicContext();
            nmContext.setInput( numbers );
            S_PIPELINE.execute( nmContext );
            return nmContext.getSortedValues();
        }
}
```
Another Sample reusing some of the stages in the previous sample
```
/**
 * A sample client class to demonstrate the usage of Pipeline Pattern
 * 
 * Takes an array of integers as input and does the following 
 * calculate the product of all numbers
 * Increase each value in the array by adding the product
 * sort the numbers
 * the sorted list is returned
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */
public class NumberMagicWithProduct
{
    private static final Pipeline S_PIPELINE = new SequentialPipeline();

    static
    {
        S_PIPELINE.addStage( new GetProductStage() );
        S_PIPELINE.addStage( new IncreaseValueStage() );
        S_PIPELINE.addStage( new SortStage() );
    }

    public int[] doMagic( int[] numbers )
    {
        NumberMagicContext nmContext = new NumberMagicContext();
        nmContext.setInput( numbers );
        S_PIPELINE.execute( nmContext );
        return nmContext.getSortedValues();
    }
}
```
### Related Patterns
**Composite patterns** can be used to represent the relation between stages and pipelines. The Pipeline itself can be a stage and can become the stage in another pipeline.

### References
[This paper](http://www.cise.ufl.edu/research/ParallelPatterns/PatternLanguage/AlgorithmStructure/Pipeline.htm) formally defines theory of Pipeline Pattern.
