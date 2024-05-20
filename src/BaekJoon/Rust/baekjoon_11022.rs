use std::io::stdin;

pub fn baekjoon_11022() {
    let mut result: String = String::new();
    let mut n: String = String::new();
    
    stdin().read_line(&mut n).unwrap();
    
    let mut range: i32 = n.trim().parse().unwrap();
    
    for index in 0..range {
        let mut line: String = String::new();
        
        stdin().read_line(&mut line).unwrap();
        
        let mut iterator = line.split_whitespace();
        let a: i32 = iterator.next().unwrap().parse().unwrap();
        let b: i32 = iterator.next().unwrap().parse().unwrap();
        
        result.push_str(&format!("Case #{}: {} + {} = {}\n", (index + 1), a, b, (a + b)));
    }
    
    println!("{}", result);
}