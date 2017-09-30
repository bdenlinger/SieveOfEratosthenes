/* 
 * This file is part of an Sieve of Eratosthenes
 * Brian Denlinger
 * brian.denlinger1@gmail.com
 * 
 * This is free software: you can redistribute it and/or modify  
 * it under the terms of the GNU Lesser General Public License as   
 * published by the Free Software Foundation, version 2.1.
 *
 * This is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package sieve;

import java.util.BitSet;
import java.util.List;
import java.util.ArrayList;

public class Sieve
{
    private BitSet sieve;

    public Sieve(int nbits)
    {
        sieve = new BitSet((nbits + 1) / 2);
    }

    public boolean isComp(int n)
    {
        assert n >= 3 && (n % 2) == 1;
        return sieve.get((n - 3) / 2);
    }

    public void setComp(int n)
    {
        assert n >= 3 && (n % 2) == 1;
        sieve.set((n - 3) / 2);
    }

    public List<Integer> sieveOfEratosthenes(int max)
    {
        Sieve sieve = new Sieve(max + 1);
        for (int i = 3; i * i <= max; i += 2)
        {
            if (sieve.isComp(i)) continue;

            for (int multiplei = i * i; multiplei <= max; multiplei += 2 * i)
                sieve.setComp(multiplei);
        }

        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for (int i = 3; i <= max; i += 2)
            if (!sieve.isComp(i)) primes.add(i);
        return primes;
    }
}