import java.util.NoSuchElementException;
class PeekingIterator implements Iterator<Integer> {
    Integer next;
    Iterator<Integer> iter;
    boolean noSuchElement;

    public PeekingIterator(Iterator<Integer> iterator) {
	iter = iterator;
        advanceIter();
    }

    public Integer peek() {
          return next;
    }

    @Override
    public Integer next() {
        if (noSuchElement)
            throw new NoSuchElementException();
        Integer res = next;
        advanceIter();
        return res;
    }

    @Override 
    public boolean hasNext() {
        return !noSuchElement;
    }
    
    private void advanceIter() {
        if (iter.hasNext()) {
            next = iter.next();
        } else {
            noSuchElement = true;
        }
    }
}