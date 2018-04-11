/* **********************************************************
 * Copyright 2011 VMware, Inc.  All rights reserved.
 *      -- VMware Confidential
 * **********************************************************/

package com.vmware.eam.sample.solution.util;

/**
 * <code>Pair</code> is a datastructure to create a pair of two objects.
 *
 * @param <S> The type of the first object.
 * @param <T> The type of the second object.
 */
public class Pair<S, T> {

   private final S _first;
   private final T _second;

   private Pair(S first, T second) {
      this._first = first;
      this._second = second;
   }

   /**
    * Creates a pair of two objects. Use this to create a Pair object, since
    * there is no public constructor.
    *
    * @param <S> The type of the first element.
    * @param <T> The type of the second element.
    * @param first The first object.
    * @param second The second object.
    * @return The created pair.
    */
   public static <S, T> Pair<S, T> create(S first, T second) {
      return new Pair<S, T>(first, second);
   }

   /**
    * Returns the first element.
    *
    * @return The first element.
    */
   public S getFirst() {
      return _first;
   }

   /**
    * Returns the second element.
    *
    * @return The second element.
    */
   public T getSecond() {
      return _second;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((_first == null) ? 0 : _first.hashCode());
      result = prime * result + ((_second == null) ? 0 : _second.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Pair<?, ?> other = (Pair<?, ?>) obj;
      if (_first == null) {
         if (other._first != null)
            return false;
      } else if (!_first.equals(other._first))
         return false;
      if (_second == null) {
         if (other._second != null)
            return false;
      } else if (!_second.equals(other._second))
         return false;
      return true;
   }

   @Override
   public String toString() {
      return "(" + _first + ", " + _second + ")";
   }

}
