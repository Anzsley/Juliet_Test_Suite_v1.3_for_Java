/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__byte_min_postdec_41.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-41.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: min Set data to the max value for byte
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: decrement
 *    GoodSink: Ensure there will not be an underflow before decrementing data
 *    BadSink : Decrement data, which can cause an Underflow
 * Flow Variant: 41 Data flow: data passed as an argument from one method to another in the same class
 *
 * */

package testcases.CWE191_Integer_Underflow.s04;
import testcasesupport.*;

public class CWE191_Integer_Underflow__byte_min_postdec_41 extends AbstractTestCase
{
    private void badSink(byte data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Byte.MIN_VALUE, this will overflow */
        data--;
        byte result = (byte)(data);

        IO.writeLine("result: " + result);

    }

    public void bad() throws Throwable
    {
        byte data;

        /* POTENTIAL FLAW: Use the maximum size of the data type */
        data = Byte.MIN_VALUE;

        badSink(data  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    private void goodG2BSink(byte data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Byte.MIN_VALUE, this will overflow */
        data--;
        byte result = (byte)(data);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        byte data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        goodG2BSink(data  );
    }

    private void goodB2GSink(byte data ) throws Throwable
    {

        /* FIX: Add a check to prevent an underflow from occurring */
        if (data > Byte.MIN_VALUE)
        {
            data--;
            byte result = (byte)(data);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too small to decrement.");
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        byte data;

        /* POTENTIAL FLAW: Use the maximum size of the data type */
        data = Byte.MIN_VALUE;

        goodB2GSink(data  );
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
