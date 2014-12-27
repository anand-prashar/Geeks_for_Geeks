package linkedLists;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import HelperPackage.UserInput;


public class q09_implement_LRUCache 
{
	static ListNode<Integer> cache, cacheLastValue;
	static Integer cacheCurrSize=0, 
				   cacheMaxSize =5;
	static List< ListNode<Integer>> allPossiblePages;
	static Hashtable<Integer, HashTableListNode > hTable;  // class defined at bottom
	
	public static void main(String[] args) 
	{
		createRAM(15); 
		Integer userNeedsEntry;
		
		while(true)
		{
			System.out.print("\nEnter data to fetch corresponding Page : ");
			userNeedsEntry=getUserData();
			ListNode<Integer>nodeAddress = getPageAddress_fromHashTable(userNeedsEntry);
			
			if(nodeAddress !=null)
			{
				System.out.println( "Found "+fetchFromCache(nodeAddress )+" : in CACHE");
			}
			else // means data does not exist in Cache : Pull from Slower RAM
			{
				ListNode<Integer> ramData=fetchFromRAM(userNeedsEntry);
				if( ramData != null) 
				{
					pushToCache_andHashTable(ramData);
					
					System.out.println("Pulled "+ramData.getData()+" from RAM, pushed to Cache");
					
				}
			}
			System.out.print("Cache : ");
			printCache();
			
		}
		
		
	}
	
	private static void pushToCache_andHashTable(ListNode<Integer> ramData) 
	{
		if(hTable==null)
		   hTable= new Hashtable<Integer, HashTableListNode >();
		
		
		
		if(cacheCurrSize >= cacheMaxSize)
			removeLeastUsedElementfromCache_adjustHTable();
		
		//add to HashTable
		hTable.put(ramData.getData(), new HashTableListNode(ramData) );
		//add to Cache
		bringToCache(ramData);
	}

	private static void bringToCache(ListNode<Integer> ramData) 
	{
		if(cache == null)
		{
			cache = ramData;
		}
		else
		{
			/*if(cacheCurrSize >= cacheMaxSize)
			{
				removeLeastUsedElementfromCache_adjustHTable();
			}*/
			cache.setPrev(ramData);
			ramData.setNext(cache);
			cache=cache.getPrev();
		}
		
		if(cacheCurrSize<cacheMaxSize)
		cacheCurrSize++;
		
	}

	private static void removeLeastUsedElementfromCache_adjustHTable() 
	{
		Set<Integer> Keys = hTable.keySet();
		Integer del_key=null, leastUsedTime=Integer.MAX_VALUE;
		
		for(Integer key:Keys)
		{
			if(hTable.get(key).LRUCount < leastUsedTime)
			{
				leastUsedTime = hTable.get(key).LRUCount;
				del_key = key;
			}
		}
		// REMOVE THE LEAST USED NODE FROM CACHE MEMORY
		ListNode<Integer> itr= cache;
		while(itr!=null)
		{
			if(itr == hTable.get(del_key).node )
			{
				if(itr.getPrev()==null)
				{
					itr.getNext().setPrev(null);
				}
				
				else if(itr.getNext()==null)
				{
					itr.getPrev().setNext(null);
				}
				else  // node lies somewhere in middle of Cache List
				{
					itr.getPrev().setNext( itr.getNext() );
					itr.getNext().setPrev( itr.getPrev() );
				}
				
			}
			itr = itr.getNext();
		}
		
		// finally remove the least-used reference from hashtable
		hTable.remove(del_key);
	}

	private static ListNode<Integer> getPageAddress_fromHashTable(Integer userNeedsEntry) 
	{
		if (hTable== null) return null;
		
		HashTableListNode value= hTable.get(userNeedsEntry);
		if(value!=null )  
		{
			
			
			value.LRUCount++;
			return value.node;
		}
		else    // Main method will take care to Call RAM memory
		return null;
	}

	private static Integer fetchFromCache(ListNode<Integer> nodeAddress) 
	{
		ListNode<Integer> temp = cache;
		while(temp !=null)
		{
			if(temp == nodeAddress) return temp.getData();
			temp=temp.getNext();
		}
		return null;
	}

	private static void createRAM(Integer PageLimit)
	{
	  allPossiblePages = new ArrayList<ListNode<Integer>>();
	  
	  for(Integer i=1;i<PageLimit;i++)
		  allPossiblePages.add( new ListNode<Integer>(i) );
	}
	
	private static ListNode<Integer> fetchFromRAM( Integer PageData)
	{
		for(ListNode<Integer> page: allPossiblePages)
		{
			if(page.getData() == PageData )
			{
				return page;
			}
		}
		System.out.println("Page does not even exist in RAM.");
		return null;
	}
	
	private static Integer getUserData()
	{
		Integer entry=null;
		
		try{
			entry=Integer.parseInt( UserInput.getUserData());
		   }
		catch(NumberFormatException e)
		{
			System.out.println("Error: This was an Invalid data");
		}
		return entry;
	}
	
	
	private static void printCache()
	{
		ListNode<Integer> temp = cache;
		
		while(temp!=null)
		{
			HashTableListNode htNode = hTable.get( temp.getData());
			if(temp.getNext()!=null)
				System.out.print(htNode.node.getData()+"("+htNode.LRUCount+")"+" ->");
				//System.out.print(temp.getData()+" ->");
			else
				System.out.print(htNode.node.getData()+"("+htNode.LRUCount+")");
			
			temp=temp.getNext();
		}
		System.out.print("\n[ "+cacheCurrSize+"/"+cacheMaxSize+" ]\n");
		System.out.println("\n");
	}
	
}

class HashTableListNode
{
	ListNode<Integer> node=null;
	Integer LRUCount=0;
	
	HashTableListNode(ListNode<Integer> makeEntry)
	{
		this.node = makeEntry;
		LRUCount++;
	}
}
