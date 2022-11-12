package com.app.design;

import java.util.Iterator;

public class PeekingIterator<T> implements Iterator<T> {

    private Iterator<T> iterator;
    private T peekedValue;

    public PeekingIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        /* If there's a value waiting in peekedValue, or if there are values
         * remaining in the iterator, we should return true. */
        return peekedValue != null || iterator.hasNext();

    }

    @Override
    public T next() {
        /* Firstly, we need to check if we have a value already
         * stored in the peekedValue variable. If we do, we need to
         * return it and also set peekedValue to null so that the value
         * isn't returned again. */
        if (peekedValue != null) {
            T toReturn = peekedValue;
            peekedValue = null;
            return toReturn;
        }
        /* As per the Java Iterator specs, we should throw a NoSuchElementException
         * if the next element doesn't exist. */
        if (!iterator.hasNext()) {
            throw null;
        }
        /* Otherwise, we need to return a new value. */
        return iterator.next();

    }

    public T peek() throws Exception {
        /* If there's not already a peeked value, get one out and store
         * it in the peekedValue variable. We aren't told what to do if
         * the iterator is actually empty -- here I have thrown an exception
         * but in an interview you should definitely ask! This is the kind of
         * thing they expect you to ask about. */
        if (peekedValue == null) {
            if (!iterator.hasNext()) {
                throw new Exception("No such elements");
            }
            peekedValue = iterator.next();
        }
        return peekedValue;
    }
}
