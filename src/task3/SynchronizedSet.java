package task3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SynchronizedSet<E> implements Set<E> {
    private final Set<E> set = new HashSet<>();
    private final Semaphore semaphore = new Semaphore(1);

    @Override
    public int size() {
        try {
            semaphore.acquire();
            int size = set.size();
            semaphore.release();
            return size;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return 0;
        }
    }

    @Override
    public boolean isEmpty() {
        try {
            semaphore.acquire();
            boolean isEmpty = set.isEmpty();
            semaphore.release();
            return isEmpty;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return true;
        }
    }

    @Override
    public boolean contains(Object o) {
        try {
            semaphore.acquire();
            boolean t = set.contains(o);
            semaphore.release();
            return t;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        try {
            semaphore.acquire();
            Iterator<E> t = set.iterator() ;
            semaphore.release();
            return t;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override
    public Object[] toArray() {
        try {
            semaphore.acquire();
            Object[] t = set.toArray() ;
            semaphore.release();
            return t;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return new Object[0];
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        try {
            semaphore.acquire();
            T[] t = set.toArray(a) ;
            semaphore.release();
            return t;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override
    public boolean add(E e) {
        try {
            semaphore.acquire();
            boolean t = set.add(e) ;
            semaphore.release();
            return t;
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            semaphore.acquire();
            boolean t = set.remove(o);
            semaphore.release();
            return t;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            semaphore.acquire();
            boolean t = set.containsAll(c);
            semaphore.release();
            return t;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        try {
            semaphore.acquire();
            boolean t = set.addAll(c);
            semaphore.release();
            return t;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            semaphore.acquire();
            boolean t = set.retainAll(c);
            semaphore.release();
            return t;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            semaphore.acquire();
            boolean t = set.removeAll(c);
            semaphore.release();
            return t;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    @Override
    public void clear() {
        set.clear();
    }
}
