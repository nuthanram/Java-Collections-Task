package datastructure;

import java.util.Arrays;

public class DynamicArray<T> {
	private int size;
	private int CAPACITY = 10;
	private final double INCREMTAL_CAPACITY = 1.5;
	private T a[];

	public DynamicArray() {
		a = (T[]) new Object[CAPACITY];
	}

	public DynamicArray(int initial_capacity) {
		if (initial_capacity <= 1)
			throw new IllegalArgumentException();
		this.CAPACITY = initial_capacity;
		a = (T[]) new Object[initial_capacity];
	}

	public int size() {
		return size;
	}

	public boolean add(T data) {
		a[size] = data;
		size++;
		if (CAPACITY == size)
			resize();
		return true;
	}

	private void resize() {
		a = Arrays.copyOf(a, (int) (CAPACITY * INCREMTAL_CAPACITY));
	}

	public boolean add(int index, T data) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		if (index == size)
			return add(data);
		T temp = a[index];
		a[index] = data;
		for (int i = index + 1; i <= size; i++) {
			T t = a[i];
			a[i] = temp;
			temp = t;
		}
		size++;
		if (size == CAPACITY)
			resize();
		return true;
	}

	public T get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		return a[index];
	}

	public void clear() {
		a = null;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int indexOf(T data) {
		for (int j = 0; j < size; j++)
			if (a[j] == null) {
				if (data == null)
					return j;
				continue;
			} else if (a[j].equals(data))
				return j;
		return -1;
	}

	public int lastIndexOf(T data) {
		for (int i = size - 1; i >= 0; i--) {
			if (a[i] == data) {
				if (data == null)
					return i;
				continue;
			} else if (a[i].equals(data))
				return i;
		}
		return -1;
	}

	public boolean contains(T data) {
		return indexOf(data) != -1;
	}

	public T remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		T data = a[index];
		for (int i = index + 1; i < size; i++) {
			a[i - 1] = a[i];
		}
		size--;
		return data;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		boolean x = false;
		sb.append('[');
		for (int i = 0; i < size; i++) {
			if (x)
				sb.append(',');
			sb.append(a[i]);
			x = true;
		}
		sb.append(']');
		return sb.toString();
	}

}
