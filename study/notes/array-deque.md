# ArrayDeque를 사용하는 이유

Java에서 큐(Queue)와 스택(Stack)를 구현할 때 일반적으로 `ArrayDeque`를 사용하는 것이 권장된다.

- **큐 구현:** `LinkedList` 대신 `ArrayDeque` 사용
- **스택 구현:** `Stack` 대신 `ArrayDeque` 사용

## 1. LinkedList 대신 ArrayDeque를 사용하는 이유 (Queue)

### 메모리 효율

- `LinkedList`는 각 요소마다 별도의 노드 객체를 생성하고, 이전·다음 노드에 대한 참조 정보를 저장해야 한다.
- `ArrayDeque`는 하나의 배열에 요소의 참조를 저장하므로 메모리 오버헤드가 상대적으로 적다.

### 캐시 효율

- `LinkedList`는 노드들이 메모리의 서로 다른 위치에 흩어져 있을 수 있어 캐시 효율이 떨어질 수 있다.
- `ArrayDeque`는 배열에 참조들이 연속적으로 저장되므로 메모리 접근의 지역성이 좋아 캐시를 효율적으로 활용할 수 있다.

### 연산 성능

- `LinkedList`는 `offer()`, `poll()` 수행 시 노드의 연결 관계를 변경한다.
- `ArrayDeque`는 **순환 배열(Circular Array)** 구조를 사용하여 `head`, `tail` 인덱스를 변경하는 방식으로 동작한다. ([[circular-array]] 내용 참고)
- 따라서 배열 기반이지만 양 끝에서 삽입·삭제할 때 기존 요소들을 이동시킬 필요가 없다.
- `LinkedList`의 양 끝 삽입·삭제는 O(1), `ArrayDeque`는 배열 확장을 고려하면 분할 상환 O(1)이다.
- `ArrayDeque`는 노드 객체 생성 비용이 없고 캐시 효율도 좋아 일반적인 큐 연산에서 더 좋은 성능을 기대할 수 있다.

**결론:** 양 끝에서 삽입과 삭제가 발생하는 큐를 구현할 때는 일반적으로 `ArrayDeque`가 더 적합하다.

---

## 2. Stack 대신 ArrayDeque를 사용하는 이유 (Stack)

### 동기화 비용

- `Stack`은 `Vector`를 상속하는 레거시 클래스이며, 주요 메서드에 `synchronized`가 적용되어 있다.
- `ArrayDeque`는 기본적으로 동기화를 수행하지 않는다.
- 코딩테스트와 같은 단일 스레드 환경에서는 동기화가 필요하지 않으므로 `ArrayDeque`가 불필요한 동기화 비용을 줄일 수 있다.
- 따라서 일반적으로 `ArrayDeque`가 더 좋은 실행 성능을 기대할 수 있다.

### API 설계

- `Stack`은 `Vector`를 상속하므로 인덱스를 이용한 요소 조회 및 수정 등 스택의 LIFO 구조에 적합하지 않은 메서드까지 제공한다.
- `ArrayDeque`는 `Deque` 인터페이스를 구현하며, 스택에 필요한 `push()`, `pop()`, `peek()` 등의 연산을 제공한다.
- `Deque` 인터페이스 타입으로 선언하면 스택과 큐에 필요한 연산을 중심으로 사용할 수 있어 자료구조의 목적을 명확하게 표현할 수 있다.

### 공식 권장 사항

- Java 공식 문서에서는 기존 `Stack` 클래스보다 `Deque` 인터페이스와 그 구현체를 사용하는 것을 권장한다.
- `ArrayDeque`는 배열 기반의 `Deque` 구현체로, 스택 연산을 효율적으로 수행할 수 있다.
- 두 자료구조 모두 스택의 PUSH/POP 연산을 효율적으로 처리하지만, `ArrayDeque`는 동기화 비용이 없고 API 설계 측면에서도 이점이 있다.

**결론:** 별도의 동기화가 필요하지 않은 스택을 구현할 때는 일반적으로 `Stack`보다 `ArrayDeque`가 더 적합하다.

---

## 3. 사용 방법

### Queue

```java
Queue<Integer> queue = new ArrayDeque<>();

queue.offer(1);  // 삽입
queue.poll();    // 삭제
queue.peek();    // 맨 앞 요소 조회
```

### Stack

```java
Deque<Integer> stack = new ArrayDeque<>();

stack.push(1);   // 삽입
stack.pop();     // 삭제
stack.peek();    // 최상단 요소 조회
```

### 주의사항

- `ArrayDeque`는 `null` 요소를 허용하지 않는다.
- `ArrayDeque`는 스레드 안전하지 않으므로 여러 스레드가 동시에 수정하는 환경에서는 별도의 동기화가 필요하다.
- `Stack`의 `peek()`은 비어 있을 때 예외를 발생시키지만, `ArrayDeque`의 `peek()`은 `null`을 반환한다.
- `ArrayDeque`가 모든 상황에서 더 빠른 것은 아니며, 실제 성능은 데이터 크기와 실행 환경에 따라 달라질 수 있다.

## 4. 최종 정리

| 비교 대상 | ArrayDeque를 선택하는 주요 이유 |
|---|---|
| `LinkedList` | 메모리 효율, 캐시 지역성, 노드 객체 생성 비용 감소 |
| `Stack` | 불필요한 동기화 비용 제거, 적합한 API 설계, Java 공식 권장 |

**따라서 Java에서 단일 스레드 기반의 일반적인 큐와 스택을 구현할 때는 `ArrayDeque`를 기본 선택으로 사용한다.**