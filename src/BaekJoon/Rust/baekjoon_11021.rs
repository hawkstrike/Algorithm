use std::io::stdin;

pub fn baekjoon_11021() {
    let mut result: String = String::new();
    let mut input: String = String::new();
    
    stdin().read_line(&mut input).unwrap();
    
    let n: i32 = input.trim().parse().unwrap();
    
    for index in 0..n {
        let mut line: String = String::new();
        
        stdin().read_line(&mut line).unwrap();
        
        let mut iterator = line.split_whitespace();
        let a: i32 = iterator.next().unwrap().parse().unwrap();
        let b: i32 = iterator.next().unwrap().parse().unwrap();
        let sum: i32 = a + b;
        
        result.push_str(&format!("Case #{}: {}\n", (index + 1), sum));
    }
    
    println!("{}", result);
}