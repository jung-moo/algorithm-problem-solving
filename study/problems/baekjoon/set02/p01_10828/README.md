## 1. 문제 내용

**백준 10828번 - 스택**

정수를 저장하는 스택을 구현하고, 입력으로 주어지는 명령을 처리하는 문제다.

지원해야 하는 명령은 다음과 같다.

- `push X`: 정수 X를 스택에 넣는다.
- `pop`: 스택의 가장 위에 있는 정수를 빼고 출력한다. 비어 있으면 -1을 출력한다.
- `size`: 스택에 들어 있는 정수의 개수를 출력한다.
- `empty`: 스택이 비어 있으면 1, 아니면 0을 출력한다.
- `top`: 스택의 가장 위에 있는 정수를 출력한다. 비어 있으면 -1을 출력한다.

**입력 조건**
- 첫째 줄에 명령의 수 N이 주어진다. (1 ≤ N ≤ 10,000)
- 둘째 줄부터 N개의 명령이 주어진다.
- `push` 명령에 사용되는 정수 X는 1 이상 100,000 이하다.

**출력 조건**
- 출력이 필요한 명령마다 결과를 한 줄씩 출력한다.

## 2. 문제 등급

- **실버 4 (Silver IV)**

## 3. 문제 유형

- 자료구조
- 스택 (Stack)
- 구현

## 4. 테스트 케이스

### 테스트 케이스 1 - 빈 스택 및 경계 조건

**입력**
```text
8
pop
top
empty
size
push 7
top
pop
empty
```

**예상 출력**
```text
-1
-1
1
0
7
7
1
```

### 테스트 케이스 2 - 기본 스택 동작

**입력**
```text
12
push 10
push 20
top
size
pop
push 30
top
empty
pop
pop
pop
empty
```

**예상 출력**
```text
20
2
20
30
0
30
10
-1
1
```

### 테스트 케이스 3 - 연속 삽입 및 삭제

**입력**
```text
30
push 1
push 2
push 3
size
top
pop
push 4
push 5
top
size
pop
pop
top
push 6
push 7
push 8
size
pop
pop
pop
pop
pop
empty
pop
push 9
top
empty
pop
size
top
```

**예상 출력**
```text
3
3
3
5
4
5
4
2
5
8
7
6
2
1
1
-1
9
0
9
0
-1
```