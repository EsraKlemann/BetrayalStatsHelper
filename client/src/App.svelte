<script>
    export let name;

    let selected = { id: 0, text: " " };

    let character;

    let characters = [
        { id: 1, text: `Father Rhinehardt` },
        { id: 2, text: `Professor Longfellow` },
        { id: 3, text: `Peter Akimoto` },
        { id: 4, text: `Brandon Jaspers` },
        { id: 5, text: `JennyLeClerc` },
        { id: 6, text: `Heather Granville` },
        { id: 7, text: `Vivian Lopez` },
        { id: 8, text: `Madame Zostra` },
        { id: 9, text: `Darrin "Flash" Williams` },
        { id: 10, text: `Ox Bellows` },
        { id: 11, text: `Zoe Ingstrom` },
        { id: 12, text: `Miss Dubourde` },
    ];

    async function updateCharacterInfo(e) {
        const response = await fetch(
            `http://localhost:8090/betrayal/api/character?id=${selected.id}`
        );

        if (response.ok) {
            const received = await response.json();
            character = received;
        }
    }
</script>

<main>
    <h1>Hello {name}!</h1>
    <p>Pick a character:</p>
    <select bind:value={selected} on:change={(e) => updateCharacterInfo(e)}>
        {#each characters as character}
            <option value={character}>
                {character.text}
            </option>
        {/each}
    </select>

    {#if character}
        {@html `<p>${character.name}</p>`}
        <p>{character.age}</p>
        <p>Stat1</p>
        <p>Stat2</p>
        <p>Stat3</p>
        <p>Stat4</p>
    {/if}
</main>

<style>
    main {
        text-align: center;
        padding: 1em;
        max-width: 240px;
        margin: 0 auto;
    }

    h1 {
        color: #ff3e00;
        text-transform: uppercase;
        font-size: 4em;
        font-weight: 100;
    }

    @media (min-width: 640px) {
        main {
            max-width: none;
        }
    }
</style>
