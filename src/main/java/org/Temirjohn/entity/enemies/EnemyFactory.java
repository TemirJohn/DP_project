package org.Temirjohn.entity.enemies;

import org.Temirjohn.entity.Direction;

public class EnemyFactory {
    public EnemyFactory() { }

    public IEnemy createEnemy(int x, int y, EnemyType type, Direction dir) {
        switch(type) {
	        case EnemyType1:
	        	return new Enemy(x, y, EnemyType.EnemyType1, dir);
	        case EnemyType2:
	        	return new Enemy(x, y, EnemyType.EnemyType2, dir);
	        case EnemyType3:
	        	return new Enemy(x, y, EnemyType.EnemyType3, dir);
	        default:
	        	return null;
        }    	
    }
    
    public IEnemy createDecoratedEnemy(Enemy baseEnemy, int decoratorType) {
    	if(decoratorType == 1)
    		return new UpgradedEnemy30H(baseEnemy);
    	else if(decoratorType == 2) {
    		return new UpgradedEnemy20S(baseEnemy);
    	}
    	else {
    		return baseEnemy;
    	}
    }
}
