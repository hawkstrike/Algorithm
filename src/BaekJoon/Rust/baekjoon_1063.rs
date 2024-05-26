use std::collections::HashMap;
use std::io::stdin;

const HORIZON_DIRECTION_VALUE: [(char, i32); 2] = [
    ('L', -1),
    ('R', 1),
];
const VERTICAL_DIRECTION_VALUE: [(char, i32); 2] = [
    ('B', -1),
    ('T', 1),
];

pub fn baekjoon_1063() {
    let horizon_direction_hash_map: HashMap<char, i32> = HORIZON_DIRECTION_VALUE.iter().cloned().collect();
    let vertical_direction_hash_map: HashMap<char, i32> = VERTICAL_DIRECTION_VALUE.iter().cloned().collect();
    let mut line: String = String::new();
    
    stdin().read_line(&mut line).unwrap();
    
    let king_stone_n: Vec<String> = line.split_whitespace().map(|s| s.parse().unwrap()).collect();
    let (king, stone, mut n) = (&king_stone_n[0].trim(), &king_stone_n[1].trim(), (&king_stone_n[2]).trim().parse::<i32>().unwrap());
    let (mut king_vector, mut stone_vector) = (king.chars().collect::<Vec<char>>(), stone.chars().collect::<Vec<char>>());
    
    while n > 0 {
        n -= 1;
        
        let (mut x, mut y) = (0, 0);
        let mut direction: String = String::new();
        
        stdin().read_line(&mut direction).unwrap();
        
        let mut direction_vector = direction.trim().chars().collect::<Vec<char>>();
        
        let horizon: Option<&i32> = horizon_direction_hash_map.get(&direction_vector[0]);
        
        if horizon.is_none() {
            let vertical: &i32 = vertical_direction_hash_map.get(&direction_vector[0]).unwrap();
            
            y += vertical;
        } else {
            x += horizon.unwrap();
            
            if direction_vector.len() == 2 {
                let vertical: &i32 = vertical_direction_hash_map.get(&direction_vector[1]).unwrap();
                
                y += vertical;
            }
        }
        
        if king_vector[0] as i32 + x >= 'A' as i32 && king_vector[0] as i32 + x <= 'H' as i32
            && king_vector[1] as i32 + y >= '1' as i32 && king_vector[1] as i32 + y <= '8' as i32 {
            king_vector[0] = (king_vector[0] as i32 + x) as u8 as char;
            king_vector[1] = (king_vector[1] as i32 + y) as u8 as char;
            
            if king_vector[0] == stone_vector[0] && king_vector[1] == stone_vector[1] {
                if stone_vector[0] as i32 + x >= 'A' as i32 && stone_vector[0] as i32 + x <= 'H' as i32
                    && stone_vector[1] as i32 + y >= '1' as i32 && stone_vector[1] as i32 + y <= '8' as i32 {
                    stone_vector[0] = (stone_vector[0] as i32 + x) as u8 as char;
                    stone_vector[1] = (stone_vector[1] as i32 + y) as u8 as char;
                } else {
                    king_vector[0] = (king_vector[0] as i32 - x) as u8 as char;
                    king_vector[1] = (king_vector[1] as i32 - y) as u8 as char;
                }
            };
        }
    }
    
    println!("{}", king_vector.iter().collect::<String>());
    println!("{}", stone_vector.iter().collect::<String>());
}